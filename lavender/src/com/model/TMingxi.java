package com.model;

/**
 * TMingxi entity. @author MyEclipse Persistence Tools
 */

public class TMingxi implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer orderId;
	private Integer goodsId;
	private Integer goodsShuliang;

	private TGoods goods;//表里没有。自己加的
	// Constructors

	/** default constructor */
	public TMingxi()
	{
	}

	/** full constructor */
	public TMingxi(Integer orderId, Integer goodsId, Integer goodsShuliang)
	{
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsShuliang = goodsShuliang;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(Integer orderId)
	{
		this.orderId = orderId;
	}

	public Integer getGoodsId()
	{
		return this.goodsId;
	}

	public TGoods getGoods()
	{
		return goods;
	}

	public void setGoods(TGoods goods)
	{
		this.goods = goods;
	}

	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}

	public Integer getGoodsShuliang()
	{
		return this.goodsShuliang;
	}

	public void setGoodsShuliang(Integer goodsShuliang)
	{
		this.goodsShuliang = goodsShuliang;
	}

}