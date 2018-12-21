package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.THuiyuanDAO;
import com.model.THuiyuan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class huiyuanAction extends ActionSupport
{
	private Integer id;
	private String loginname;
	private String loginpw;
	private String xingming;
	
	private String xingbie;
	private String nianling;
	private String address;
	private String dianhua;
	
	private Integer yue;
	private String del;
	
	private String message;
	private String path;
	
	private THuiyuanDAO huiyuanDAO;
	
	
	
	public String huiyuanReg()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from THuiyuan where loginname=?";
		Object[] c={loginname.trim()};
		List huiyuanList=huiyuanDAO.getHibernateTemplate().find(sql,c);
		if(huiyuanList.size()>0)
		{
			this.setMessage("账号已被占用，请重新注册");
			this.setPath("qiantai/user/userReg.jsp");
		}
		else
		{
			THuiyuan huiyuan=new THuiyuan();
			
			//huiyuan.setId(id);
			huiyuan.setLoginname(loginname);
			huiyuan.setLoginpw(loginname);
			huiyuan.setXingming(xingming);
			
			huiyuan.setXingbie(xingbie);
			huiyuan.setNianling(nianling);
			huiyuan.setAddress(address);
			huiyuan.setDianhua(dianhua);
			
			huiyuan.setYue(0);
			huiyuan.setDel("no");
			
			huiyuanDAO.save(huiyuan);
			
			this.setMessage("注册成功，请登录");
			this.setPath("qiantai/user/userLogin.jsp");
		}
		
		return "succeed";
	}
	
	
	public String huiyuanEdit()
	{
		    THuiyuan huiyuan=huiyuanDAO.findById(id);
			
			//huiyuan.setId(id);
			huiyuan.setLoginname(loginname);
			huiyuan.setLoginpw(loginpw);
			huiyuan.setXingming(xingming);
			
			huiyuan.setXingbie(xingbie);
			huiyuan.setNianling(nianling);
			huiyuan.setAddress(address);
			huiyuan.setDianhua(dianhua);
			
			huiyuanDAO.attachDirty(huiyuan);
			
			this.setMessage("修改成功，重新登陆后生效");
			this.setPath("qiantai/default.jsp");
		
		    return "succeed";
	}
		
	

	public String huiyuanMana()
	{
		String sql="from THuiyuan where del='no'";
		List huiyuanList=huiyuanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("huiyuanList", huiyuanList);
		return ActionSupport.SUCCESS;
	}
	
	public String huiyuanDel()
	{
		THuiyuan huiyuan=huiyuanDAO.findById(id);
		huiyuan.setDel("yes");
		huiyuanDAO.attachDirty(huiyuan);
		
		this.setMessage("删除成功");
		this.setPath("huiyuanMana.action");
		return "succeed";
	}
	
	
	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLoginname()
	{
		return loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public THuiyuanDAO getHuiyuanDAO()
	{
		return huiyuanDAO;
	}

	public void setHuiyuanDAO(THuiyuanDAO huiyuanDAO)
	{
		this.huiyuanDAO = huiyuanDAO;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getDianhua()
	{
		return dianhua;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}

	public Integer getYue()
	{
		return yue;
	}

	public void setYue(Integer yue)
	{
		this.yue = yue;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

}
