package com.model;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String bianhao;
	private String xiadanshi;
	private String zt;//待受理--已受理
	
	private String songhuodizhi;
	private String fukuanfangshi;
	private Integer zongjia;
	private Integer huiyuanId;

	// Constructors

	/** default constructor */
	public TOrder()
	{
	}

	/** full constructor */
	public TOrder(String bianhao, String xiadanshi, String zt,
			String songhuodizhi, String fukuanfangshi, Integer zongjia,
			Integer huiyuanId)
	{
		this.bianhao = bianhao;
		this.xiadanshi = xiadanshi;
		this.zt = zt;
		this.songhuodizhi = songhuodizhi;
		this.fukuanfangshi = fukuanfangshi;
		this.zongjia = zongjia;
		this.huiyuanId = huiyuanId;
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

	public String getBianhao()
	{
		return this.bianhao;
	}

	public void setBianhao(String bianhao)
	{
		this.bianhao = bianhao;
	}

	public String getXiadanshi()
	{
		return this.xiadanshi;
	}

	public void setXiadanshi(String xiadanshi)
	{
		this.xiadanshi = xiadanshi;
	}

	public String getZt()
	{
		return this.zt;
	}

	public void setZt(String zt)
	{
		this.zt = zt;
	}

	public String getSonghuodizhi()
	{
		return this.songhuodizhi;
	}

	public void setSonghuodizhi(String songhuodizhi)
	{
		this.songhuodizhi = songhuodizhi;
	}

	public String getFukuanfangshi()
	{
		return this.fukuanfangshi;
	}

	public void setFukuanfangshi(String fukuanfangshi)
	{
		this.fukuanfangshi = fukuanfangshi;
	}

	public Integer getZongjia()
	{
		return this.zongjia;
	}

	public void setZongjia(Integer zongjia)
	{
		this.zongjia = zongjia;
	}

	public Integer getHuiyuanId()
	{
		return this.huiyuanId;
	}

	public void setHuiyuanId(Integer huiyuanId)
	{
		this.huiyuanId = huiyuanId;
	}

}