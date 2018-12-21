package com.model;

/**
 * TXianhua entity. @author MyEclipse Persistence Tools
 */

public class TXianhua implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String mingcheng;
	private Integer kucun;
	private String del;

	// Constructors

	/** default constructor */
	public TXianhua()
	{
	}

	/** full constructor */
	public TXianhua(String mingcheng, String del)
	{
		this.mingcheng = mingcheng;
		this.del = del;
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

	public Integer getKucun()
	{
		return kucun;
	}

	public void setKucun(Integer kucun)
	{
		this.kucun = kucun;
	}

	public String getMingcheng()
	{
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}