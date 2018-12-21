package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TMingxiDAO;
import com.dao.TOrderDAO;
import com.model.TGoods;
import com.model.THuiyuan;
import com.model.TMingxi;
import com.model.TOrder;
import com.model.TXianhua;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Cart;

public class buyAction extends ActionSupport
{
	private TGoodsDAO goodsDAO;
	private TOrderDAO orderDAO;
	private TMingxiDAO mingxiDAO;
	
	private String message;
	private String path;
	
	public String addToCart()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		int shuliang=Integer.parseInt(request.getParameter("shuliang"));
		
		TGoods goods=goodsDAO.findById(goodsId);
		
		
		TMingxi mingxi=new TMingxi();
		mingxi.setGoods(goods);
		mingxi.setGoodsShuliang(shuliang);
		
		Cart cart = (Cart)session.getAttribute("cart");
		cart.addGoods(goodsId, mingxi);
		session.setAttribute("cart",cart);
		
		this.setMessage("成功购物");
		this.setPath("myCart.action");
		return "succeed";
	}
	
	
	
	public String myCart()
	{
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderQueren()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderSubmit()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		THuiyuan huiyuan=(THuiyuan)session.getAttribute("huiyuan");
		
		TOrder order=new TOrder();
		//order.setId(id);
		order.setBianhao(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		order.setXiadanshi(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		order.setZt("待受理");
		
		order.setSonghuodizhi(request.getParameter("songhuodizhi"));
		order.setFukuanfangshi(request.getParameter("fukuanfangshi"));
		order.setZongjia(cart.getTotalPrice());
		order.setHuiyuanId(huiyuan.getId());
		
		
		orderDAO.save(order);
		
		for (Iterator it = cart.getItems().values().iterator(); it.hasNext();)
		{

			TMingxi mingxi = (TMingxi) it.next();
			
			mingxi.setOrderId(order.getId());
			mingxi.setGoodsId(mingxi.getGoods().getId());
			
			//goodsDAO.getHibernateTemplate().bulkUpdate("update TGoods set kucun=kucun-"+mingxi.getGoodsShuliang() +" where id="+mingxi.getGoods().getId());
			
			mingxiDAO.save(mingxi);
		}
		
		cart.getItems().clear();
		session.setAttribute("cart", cart);
		
		request.setAttribute("order", order);
		
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	public String orderMine()
	{
		Map session= ServletActionContext.getContext().getSession();
		THuiyuan huiyuan=(THuiyuan)session.get("huiyuan");
		
		String sql="from TOrder where huiyuanId="+huiyuan.getId();
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String orderDel()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.parseInt(request.getParameter("id"));
		
		TOrder order=orderDAO.findById(id);
		orderDAO.delete(order);
		
		this.setMessage("订单删除完毕");
		this.setPath("orderMine.action");
		return "succeed";
		
	}
	
	
	
	public String orderMana()
	{
		String sql="from TOrder order by zt desc";
		List orderList=orderDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String orderShouli()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.parseInt(request.getParameter("id"));
		
		TOrder order=orderDAO.findById(id);
		order.setZt("已受理");
		orderDAO.attachDirty(order);
		
		request.setAttribute("msg", "受理订单成功");
		return "msg";
	}
	
	public String orderDelAd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.parseInt(request.getParameter("id"));
		
		TOrder order=orderDAO.findById(id);
		orderDAO.delete(order);
		
		request.setAttribute("msg", "信息删除完毕");
		return "msg";
		
	}
	
	public String orderDetail()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		
		String sql="from TMingxi where orderId="+orderId;
		List mingxiList=mingxiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<mingxiList.size();i++)
		{
			TMingxi mingxi=(TMingxi)mingxiList.get(i);
			mingxi.setGoods(goodsDAO.findById(mingxi.getGoodsId()));
		}
		request.setAttribute("mingxiList", mingxiList);
		return ActionSupport.SUCCESS;
	}

	
	
	public String tongjiRes()
	{
		HttpServletRequest request1=ServletActionContext.getRequest();
		String shijian1=request1.getParameter("shijian1");
		String shijian2=request1.getParameter("shijian2");
		
		String sql="from TOrder where xiadanshi >=? and xiadanshi<=?";
		Object[] o={shijian1,shijian2};
		List orderList=orderDAO.getHibernateTemplate().find(sql,o);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}

	
	


	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}



	public TMingxiDAO getMingxiDAO()
	{
		return mingxiDAO;
	}



	public void setMingxiDAO(TMingxiDAO mingxiDAO)
	{
		this.mingxiDAO = mingxiDAO;
	}



	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}



	public TOrderDAO getOrderDAO()
	{
		return orderDAO;
	}



	public void setOrderDAO(TOrderDAO orderDAO)
	{
		this.orderDAO = orderDAO;
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
