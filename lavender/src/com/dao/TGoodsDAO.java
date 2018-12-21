package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TGoods;

/**
 * A data access object (DAO) providing persistence and search support for
 * TGoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TGoods
 * @author MyEclipse Persistence Tools
 */

public class TGoodsDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGoodsDAO.class);
	// property constants
	public static final String MINGCHENG = "mingcheng";
	public static final String JIESHAO = "jieshao";
	public static final String FUJIAN = "fujian";
	public static final String JIAGE = "jiage";
	public static final String TEJIA = "tejia";
	public static final String SHIFOUTEJIA = "shifoutejia";
	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TGoods transientInstance)
	{
		log.debug("saving TGoods instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TGoods persistentInstance)
	{
		log.debug("deleting TGoods instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TGoods findById(java.lang.Integer id)
	{
		log.debug("getting TGoods instance with id: " + id);
		try
		{
			TGoods instance = (TGoods) getHibernateTemplate().get(
					"com.model.TGoods", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGoods instance)
	{
		log.debug("finding TGoods instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TGoods instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TGoods as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMingcheng(Object mingcheng)
	{
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByJieshao(Object jieshao)
	{
		return findByProperty(JIESHAO, jieshao);
	}

	public List findByFujian(Object fujian)
	{
		return findByProperty(FUJIAN, fujian);
	}

	public List findByJiage(Object jiage)
	{
		return findByProperty(JIAGE, jiage);
	}

	public List findByTejia(Object tejia)
	{
		return findByProperty(TEJIA, tejia);
	}

	public List findByShifoutejia(Object shifoutejia)
	{
		return findByProperty(SHIFOUTEJIA, shifoutejia);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TGoods instances");
		try
		{
			String queryString = "from TGoods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGoods merge(TGoods detachedInstance)
	{
		log.debug("merging TGoods instance");
		try
		{
			TGoods result = (TGoods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGoods instance)
	{
		log.debug("attaching dirty TGoods instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TGoods instance)
	{
		log.debug("attaching clean TGoods instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TGoodsDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGoodsDAO) ctx.getBean("TGoodsDAO");
	}
}