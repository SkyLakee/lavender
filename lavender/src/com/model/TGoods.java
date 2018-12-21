package com.model;

/**
 * TGoods entity. @author MyEclipse Persistence Tools
 */

public class TGoods implements java.io.Serializable
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
	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getLeibieId()
	{
		return leibieId;
	}

	public void setLeibieId(Integer leibieId)
	{
		this.leibieId = leibieId;
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

}