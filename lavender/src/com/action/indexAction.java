package com.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TLeibieDAO;
import com.dao.TLianjieDAO;
import com.dao.TMingxiDAO;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TLeibieDAO leibieDAO;
	private TLianjieDAO lianjieDAO;
	private TGoodsDAO goodsDAO;
	private TMingxiDAO mingxiDAO;

	public TLeibieDAO getLeibieDAO()
	{
		return leibieDAO;
	}


	public TLianjieDAO getLianjieDAO()
	{
		return lianjieDAO;
	}


	public TMingxiDAO getMingxiDAO()
	{
		return mingxiDAO;
	}


	public void setMingxiDAO(TMingxiDAO mingxiDAO)
	{
		this.mingxiDAO = mingxiDAO;
	}


	public void setLianjieDAO(TLianjieDAO lianjieDAO)
	{
		this.lianjieDAO = lianjieDAO;
	}


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}


	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}



	public void setLeibieDAO(TLeibieDAO leibieDAO)
	{
		this.leibieDAO = leibieDAO;
	}


	public String index()
	{
		Map session=ActionContext.getContext().getSession();
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TLeibie where Del='no'";
		List leibieList=leibieDAO.getHibernateTemplate().find(sql);
		session.put("leibieList", leibieList);
		
		
		sql="from TLianjie where del='no'";
		List lianjieList =lianjieDAO.getHibernateTemplate().find(sql);
		session.put("lianjieList", lianjieList);
		
		
		
		sql="from TGoods where del='no' and shifoutejia='no' order by id desc";
		List xinpinList=goodsDAO.getHibernateTemplate().find(sql);
		if(xinpinList.size()>4)
		{
			xinpinList=xinpinList.subList(0, 4);
		}
		request.put("xinpinList", xinpinList);
		
		
		
		
		
		
		
		//paihangbang
		List paihangList=new ArrayList();
		sql="select sum(goodsShuliang),goodsId from TMingxi group by goodsId order by sum(goodsShuliang) desc";
		List list=mingxiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<list.size();i++)
		{
			Object[] b=(Object[])list.get(i);
			int goodsId=Integer.parseInt(b[1].toString());
			
			TGoods goods=goodsDAO.findById(goodsId);
			paihangList.add(goods);
		}
		if(paihangList.size()>4)
		{
			paihangList=paihangList.subList(0, 4);
		}
		request.put("paihangList", paihangList);
		
		
		
		
		
		
		sql="from TGoods where del='no' and shifoutejia='yes' order by id desc";
		List tejiaList=goodsDAO.getHibernateTemplate().find(sql);
		if(tejiaList.size()>4)
		{
			tejiaList=tejiaList.subList(0, 4);
		}
		request.put("tejiaList", tejiaList);
		
		
		
		
		
		
		
		return ActionSupport.SUCCESS;
	}

}
