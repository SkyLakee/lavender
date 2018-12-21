package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.THuiyuanDAO;
import com.dao.TLeibieDAO;
import com.model.TAdmin;
import com.model.THuiyuan;
import com.util.Cart;

public class loginService
{
	private TAdminDAO adminDAO;
	private TLeibieDAO leibieDAO;
	private THuiyuanDAO huiyuanDAO;
	
	public THuiyuanDAO getHuiyuanDAO()
	{
		return huiyuanDAO;
	}
	public void setHuiyuanDAO(THuiyuanDAO huiyuanDAO)
	{
		this.huiyuanDAO = huiyuanDAO;
	}
	public TLeibieDAO getLeibieDAO()
	{
		return leibieDAO;
	}
	public void setLeibieDAO(TLeibieDAO leibieDAO)
	{
		this.leibieDAO = leibieDAO;
	}
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	
	public String login(String userName,String userPw,int userType)
	{
		
		String result="no";
		
		if(userType==0)//系统管理员登录
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName.trim(),userPw.trim()};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)
		{
			System.out.println(userName+"GG");
			System.out.println(userPw+"GG");
			
			String sql="from THuiyuan where loginname=? and loginpw=? and del='no'";
			Object[] con={userName.trim(),userPw.trim()};
			List huiyuanList=huiyuanDAO.getHibernateTemplate().find(sql,con);
			
			if(huiyuanList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				
				 THuiyuan huiyuan=(THuiyuan)huiyuanList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("huiyuan", huiyuan);
	             
	             Cart cart=new Cart();
				 session.setAttribute("cart", cart);
				 
	             result="yes";
			}
		}
		if(userType==2)
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    
    public void userLogout()
    {
    	WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		session.setAttribute("userType", null);
		session.setAttribute("user", null);
    }
    
    
    public List leibieSelect()
    {
    	String sql="from TLeibie where Del='no'";
		List leibieList=leibieDAO.getHibernateTemplate().find(sql);
		return leibieList;
    }
}
