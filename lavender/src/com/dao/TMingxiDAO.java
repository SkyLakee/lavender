package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TMingxi;

/**
 * A data access object (DAO) providing persistence and search support for
 * TMingxi entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TMingxi
 * @author MyEclipse Persistence Tools
 */

public class TMingxiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TMingxiDAO.class);
	// property constants
	public static final String ORDER_ID = "orderId";
	public static final String GOODS_ID = "goodsId";
	public static final String GOODS_SHULIANG = "goodsShuliang";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TMingxi transientInstance)
	{
		log.debug("saving TMingxi instance");
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

	public void delete(TMingxi persistentInstance)
	{
		log.debug("deleting TMingxi instance");
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

	public TMingxi findById(java.lang.Integer id)
	{
		log.debug("getting TMingxi instance with id: " + id);
		try
		{
			TMingxi instance = (TMingxi) getHibernateTemplate().get(
					"com.model.TMingxi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMingxi instance)
	{
		log.debug("finding TMingxi instance by example");
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
		log.debug("finding TMingxi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TMingxi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrderId(Object orderId)
	{
		return findByProperty(ORDER_ID, orderId);
	}

	public List findByGoodsId(Object goodsId)
	{
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByGoodsShuliang(Object goodsShuliang)
	{
		return findByProperty(GOODS_SHULIANG, goodsShuliang);
	}

	public List findAll()
	{
		log.debug("finding all TMingxi instances");
		try
		{
			String queryString = "from TMingxi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMingxi merge(TMingxi detachedInstance)
	{
		log.debug("merging TMingxi instance");
		try
		{
			TMingxi result = (TMingxi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMingxi instance)
	{
		log.debug("attaching dirty TMingxi instance");
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

	public void attachClean(TMingxi instance)
	{
		log.debug("attaching clean TMingxi instance");
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

	public static TMingxiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TMingxiDAO) ctx.getBean("TMingxiDAO");
	}
}