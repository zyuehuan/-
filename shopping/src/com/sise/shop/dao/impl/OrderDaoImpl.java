package com.sise.shop.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.shop.dao.OrderDao;
import com.sise.shop.po.Order;
import com.sise.shop.po.OrderItem;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		getHibernateTemplate().persist(order);
	}

	@Override
	public void updateOrder(Order order) {
		getHibernateTemplate().saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(Integer id) {
		Order order = getHibernateTemplate().get(Order.class, id);
		getHibernateTemplate().delete(order);
	}

	@Override
	public Order findOrderByid(Integer id) {
		Order order = getHibernateTemplate().get(Order.class, id);
		return order;
	}
	
	public List<Order> findOrderByUserid(final Integer id,final int page,final int pageSize){
		List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.user.id="+id+"order by o.time desc");
			query.setFirstResult(pageSize*(page-1));
			query.setMaxResults(pageSize);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return orders;
	}

	@Override
	public int getCountOrderByUserid(Integer id) {
		List<Order> orders = (List<Order>) getHibernateTemplate().find("from Order as o where o.user.id="+id);
		return orders.size();
	}

	@Override
	public List<Order> findAllOrder(final int page, final int pageSize) {
		List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order order by time desc");
			query.setFirstResult(pageSize*(page-1));
			query.setMaxResults(pageSize);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return orders;
	}

	@Override
	public int getCountAllOrder() {
		List<Order> orders = (List<Order>) getHibernateTemplate().find("from Order");
		return orders.size();
	}

	@Override
	public List<Order> findOrderByUseridOrstate(final int id, final int osid, final int curPage,
			final int pageSize) {
		List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.user.id="+id + "and o.orderstate.osid="+osid+"order by o.time desc");
			query.setFirstResult(pageSize*(curPage-1));
			query.setMaxResults(pageSize);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return orders;
	}

	@Override
	public int getCountOrderByUseridOrstate(int id, int osid) {
		List<Order> orders = (List<Order>) getHibernateTemplate().find("from Order as o where o.user.id="+id + "and o.orderstate.osid="+osid);
		return orders.size();
	}

	@Override
	public List<OrderItem> getAllstates() {
		List<OrderItem> orderitems = (List<OrderItem>) getHibernateTemplate().find("from OrderItem");
		return orderitems;
	}

	public List<Order> findOrderByUseridAndStateid(final Integer id,final Integer osid,final int page,final int pageSize){
		List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.user.id="+id+"and o.orderstate.osid="+osid+"order by time desc");
			query.setFirstResult(pageSize*(page-1));
			query.setMaxResults(pageSize);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return orders;
	}
	public int getCountOrderByUseridAndStateid(Integer id,Integer osid){
		List<Order> orders = (List<Order>) getHibernateTemplate().find("from Order as o where o.user.id="+id+"and o.orderstate.osid="+osid+"order by time desc");
		return orders.size();
	}


	public Object getCountOrderPriceByUserid(final int id) {
		Object prices = 0;
		try {
			prices = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("select sum(o.totalPrices) from Order as o where o.user.id="+id+"and o.orderstate.osid>1");
			Object pricess = query.uniqueResult();
			return pricess.toString();
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return prices;
	}

	public Object getCountOrderProductByUserid(final int id) {
		Object pronum = 0;
		try {
			pronum = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("select sum(o.countproduct) from Order as o where o.user.id="+id+"and o.orderstate.osid>1");
			Object pronums = query.uniqueResult();
			return pronums.toString();
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return pronum;
	}

	@Override
	public double getmonthPriceByUserid(final int id, final Date d1,final Date d2) {
		double prices = 0.0;
	    List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.time between :a and :b and o.user.id= :c and o.orderstate.osid>1");
			query.setParameter("a", d1).setParameter("b", d2).setParameter("c", id);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		for(int i=0;i<orders.size();i++){
			prices = prices + orders.get(i).getTotalPrices();
		}
		return prices;
	}

	@Override
	public int getmonthProductByUserid(final int id,final Date d1,final Date d2) {
		int pros = 0;
	    List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.time between :a and :b and o.user.id= :c and o.orderstate.osid>1");
			query.setParameter("a", d1).setParameter("b", d2).setParameter("c", id);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		for(int i=0;i<orders.size();i++){
			pros = pros + orders.get(i).getCountproduct();
		}
		return pros;
	}

	@Override
	public Object getCountOrderPrice() {
		Object prices = 0;
		try {
			prices = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("select sum(o.totalPrices) from Order as o where o.orderstate.osid>1");
			Object pricess = query.uniqueResult();
			return pricess.toString();
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return prices;
	}

	@Override
	public Object getCountOrderProduct() {
		Object pronum = 0;
		try {
			pronum = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("select sum(o.countproduct) from Order as o where o.orderstate.osid>1");
			Object pronums = query.uniqueResult();
			return pronums.toString();
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return pronum;
	}

	@Override
	public double getmonthPrice(final Date date, final Date date2) {
		double prices = 0.0;
	    List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.time between :a and :b and o.orderstate.osid>1");
			query.setParameter("a", date).setParameter("b", date2);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		for(int i=0;i<orders.size();i++){
			prices = prices + orders.get(i).getTotalPrices();
		}
		return prices;
	}

	@Override
	public int getmonthProduct(final Date date,final Date date2) {
		int pros = 0;
	    List<Order> orders = null;
		try {
			orders = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Order as o where o.time between :a and :b and o.orderstate.osid>1");
			query.setParameter("a", date).setParameter("b", date2);
			List orderss = query.list();
			return orderss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		for(int i=0;i<orders.size();i++){
			pros = pros + orders.get(i).getCountproduct();
		}
		return pros;
	}


	


	
}
