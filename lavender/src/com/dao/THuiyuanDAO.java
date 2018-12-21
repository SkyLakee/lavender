package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.THuiyuan;

/**
 * A data access object (DAO) providing persistence and search support for
 * THuiyuan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.THuiyuan
 * @author MyEclipse Persistence Tools
 */

public class THuiyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(THuiyuanDAO.class);
	// property constants
	public static final String LOGINNAME = "loginname";
	public static final String LOGINPW = "loginpw";
	public static final String XINGMING = "xingming";
	public static final String XINGBIE = "xingbie";
	public static final String NIANLING = "nianling";
	public static final String ADDRESS = "address";
	public static final String DIANHUA = "dianhua";
	public static final String YUE = "yue";
	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(THuiyuan transientInstance)
	{
		log.debug("saving THuiyuan instance");
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

	public void delete(THuiyuan persistentInstance)
	{
		log.debug("deleting THuiyuan instance");
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

	public THuiyuan findById(java.lang.Integer id)
	{
		log.debug("getting THuiyuan instance with id: " + id);
		try
		{
			THuiyuan instance = (THuiyuan) getHibernateTemplate().get(
					"com.model.THuiyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(THuiyuan instance)
	{
		log.debug("finding THuiyuan instance by example");
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
		log.debug("finding THuiyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from THuiyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}

	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByXingming(Object xingming)
	{
		return findByProperty(XINGMING, xingming);
	}

	public List findByXingbie(Object xingbie)
	{
		return findByProperty(XINGBIE, xingbie);
	}

	public List findByNianling(Object nianling)
	{
		return findByProperty(NIANLING, nianling);
	}

	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}

	public List findByDianhua(Object dianhua)
	{
		return findByProperty(DIANHUA, dianhua);
	}

	public List findByYue(Object yue)
	{
		return findByProperty(YUE, yue);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all THuiyuan instances");
		try
		{
			String queryString = "from THuiyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public THuiyuan merge(THuiyuan detachedInstance)
	{
		log.debug("merging THuiyuan instance");
		try
		{
			THuiyuan result = (THuiyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(THuiyuan instance)
	{
		log.debug("attaching dirty THuiyuan instance");
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

	public void attachClean(THuiyuan instance)
	{
		log.debug("attaching clean THuiyuan instance");
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

	public static THuiyuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (THuiyuanDAO) ctx.getBean("THuiyuanDAO");
	}
}