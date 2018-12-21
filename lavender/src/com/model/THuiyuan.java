package com.model;

/**
 * THuiyuan entity. @author MyEclipse Persistence Tools
 */

public class THuiyuan implements java.io.Serializable
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


	/** default constructor */
	public THuiyuan()
	{
	}

	/** full constructor */
	public THuiyuan(String loginname, String loginpw, String xingming,
			String xingbie, String nianling, String address, String dianhua,
			Integer yue, String del)
	{
		this.loginname = loginname;
		this.loginpw = loginpw;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.address = address;
		this.dianhua = dianhua;
		this.yue = yue;
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

	public String getLoginname()
	{
		return this.loginname;
	}

	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}

	public String getLoginpw()
	{
		return this.loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getXingming()
	{
		return this.xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXingbie()
	{
		return this.xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getNianling()
	{
		return this.nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getDianhua()
	{
		return this.dianhua;
	}

	public void setDianhua(String dianhua)
	{
		this.dianhua = dianhua;
	}

	public Integer getYue()
	{
		return this.yue;
	}

	public void setYue(Integer yue)
	{
		this.yue = yue;
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