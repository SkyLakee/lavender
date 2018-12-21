package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private Integer id;
	private Integer leibieId;
	private String mingcheng;
	private String jieshao;
	
	private String fujian;
	private Integer jiage;
	private Integer tejia;
	
	private String shifoutejia;
	private String del;
	
	private TGoodsDAO goodsDAO;
	
	public String goodsAdd()
	{
		TGoods goods=new TGoods();
		
		//goods.setId(id);
		goods.setLeibieId(leibieId);
		goods.setMingcheng(mingcheng);
		goods.setJieshao(jieshao);
		
		goods.setFujian(fujian);
		goods.setJiage(jiage);
		goods.setTejia(jiage);
		
		goods.setShifoutejia("no");
		goods.setDel("no");
		
		goodsDAO.save(goods);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	public String goodsMana()
	{
		String sql="from TGoods where del='no' order by leibieId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDel()
	{
		TGoods goods=goodsDAO.findById(id);
		goods.setDel("yes");
		
		goodsDAO.attachDirty(goods);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String tejiashezhi()
	{
		TGoods goods=goodsDAO.findById(id);
		goods.setShifoutejia("yes");
		goods.setTejia(tejia);
		
		goodsDAO.attachDirty(goods);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息更新成功");
		return "msg";
	}
	
	
	
	
	public String goodsAll()
	{
		String sql="from TGoods where del='no' and shifoutejia='no' order by id desc";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		if(goodsList.size()>12)
		{
			goodsList=goodsList.subList(0, 12);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsDetailQian()
	{
		TGoods goods=goodsDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String goodsByLeibie()
	{
		String sql="from TGoods where del='no' and shifoutejia='no' and leibieId=?";
		Object[] con={leibieId};
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		List goodsList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsList", goodsList);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
		}
		System.out.println(goodsList.size()+"&&");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsRes()
	{
		String sql="from TGoods where del='no' and shifoutejia='no' and mingcheng like '%"+mingcheng.trim()+"%'";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsTejia()
	{
		String sql="from TGoods where del='no' and shifoutejia='yes' order by id desc";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	


	public Integer getLeibieId()
	{
		return leibieId;
	}


	public void setLeibieId(Integer leibieId)
	{
		this.leibieId = leibieId;
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getMingcheng()
	{
		return mingcheng;
	}


	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}





	public String getJieshao()
	{
		return jieshao;
	}


	public void setJieshao(String jieshao)
	{
		this.jieshao = jieshao;
	}


	public String getFujian()
	{
		return fujian;
	}


	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}


	public Integer getJiage()
	{
		return jiage;
	}


	public void setJiage(Integer jiage)
	{
		this.jiage = jiage;
	}


	public Integer getTejia()
	{
		return tejia;
	}


	public void setTejia(Integer tejia)
	{
		this.tejia = tejia;
	}


	public String getShifoutejia()
	{
		return shifoutejia;
	}


	public void setShifoutejia(String shifoutejia)
	{
		this.shifoutejia = shifoutejia;
	}


	public String getDel()
	{
		return del;
	}


	public void setDel(String del)
	{
		this.del = del;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}


	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}
	
}
