package com.sise.shop.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sise.shop.dao.OrderDao;
import com.sise.shop.po.Order;
import com.sise.shop.po.OrderItem;
import com.sise.shop.service.OrderService;
import com.sise.shop.vo.Pager;

@Transactional(readOnly=false)
public class OrderServiceImpl implements OrderService {
	@Resource private OrderDao orderDao;
	@Override
	public void addOrder(Order order) {
		 orderDao.insertOrder(order);
	}

	@Override
	public void updateSOrder(Order order) {
		orderDao.updateOrder(order);
	}

	@Override
	public void deleteSOrder(Integer id) {
		orderDao.deleteOrder(id);
	}

	@Override
	public Order findSOrderByid(Integer id) {
		return orderDao.findOrderByid(id);
	}


	@Override
	public List<Order> findSOrderByUserid(Integer id,int page,int pageSize) {
		return orderDao.findOrderByUserid(id,page,pageSize);
	}
	
	public Pager getPagerOfOrderByUserid(int id,int pageSize){
		int count = orderDao.getCountOrderByUserid(id);
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public List<Order> findSAllOrder(int page, int pageSize) {
		return orderDao.findAllOrder(page, pageSize);
	}

	@Override
	public Pager getPagerOfAllOrder(int pageSize) {
		int count = orderDao.getCountAllOrder();
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public List<Order> findSOrderByUseridOrstate(int id, int osid, int curPage, int pageSize) {
		// TODO 自动生成的方法存根pageSize
		return orderDao.findOrderByUseridOrstate(id,osid,curPage,pageSize);
	}

	@Override
	public Pager getPagerOfOrderByUseridOrstate(int id, int osid, int pageSize) {
		int count = orderDao.getCountOrderByUseridOrstate(id,osid);
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public List<OrderItem> fingSAllstates() {
		// TODO 自动生成的方法存根
		return orderDao.getAllstates();
	}

	@Override
	public int findSOrderByUserid(Integer id) {
		return orderDao.getCountOrderByUserid(id);
	}

	@Override
	public int findSOrderByUseridAndStateid(Integer id, Integer osid) {
		return orderDao.getCountOrderByUseridAndStateid(id, osid);
	}

	@Override
	public Object findCountOrderPriceByUserid(Integer id) {
		return orderDao.getCountOrderPriceByUserid(id);
	}

	@Override
	public Object findCountOrderProductByUserid(Integer id) {
		return orderDao.getCountOrderProductByUserid(id);
	}

	@Override
	public double findmonthPriceByUserid(Integer id, Date d1,Date d2) {
		Calendar c = Calendar.getInstance();
	    c.setTime(d1);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    d1 = c.getTime();
	    Calendar c2 = Calendar.getInstance();
	    d2.setMonth(d2.getMonth()+1);
	    c2.setTime(d2);
	    c2.set(Calendar.DAY_OF_MONTH, 1);
	    c2.add(Calendar.DAY_OF_MONTH, -1);
	    d2 = c2.getTime();
		return orderDao.getmonthPriceByUserid(id, d1,d2);
	}

	@Override
	public int findmonthProductByUserid(Integer id, Date d1,Date d2) {
		Calendar c = Calendar.getInstance();
	    c.setTime(d1);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    d1 = c.getTime();
	    Calendar c2 = Calendar.getInstance();
	    d2.setMonth(d2.getMonth()+1);
	    c2.setTime(d2);
	    c2.set(Calendar.DAY_OF_MONTH, 1);
	    c2.add(Calendar.DAY_OF_MONTH, -1);
	    d2 = c2.getTime();
		return orderDao.getmonthProductByUserid(id, d1, d2);
	}

	@Override
	public Object findCountOrderPrice() {
		// TODO 自动生成的方法存根
		return orderDao.getCountOrderPrice();
	}

	@Override
	public Object findCountOrderProduct() {
		// TODO 自动生成的方法存根
		return orderDao.getCountOrderProduct();
	}

	@Override
	public double findmonthPrice(Date date, Date date2) {
		// TODO 自动生成的方法存根
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    date = c.getTime();
	    Calendar c2 = Calendar.getInstance();
	    date2.setMonth(date2.getMonth()+1);
	    c2.setTime(date2);
	    c2.set(Calendar.DAY_OF_MONTH, 1);
	    c2.add(Calendar.DAY_OF_MONTH, -1);
	    date2 = c2.getTime();
		return orderDao.getmonthPrice(date,date2);
	}

	@Override
	public int findmonthProduct(Date date, Date date2) {
		// TODO 自动生成的方法存根
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    date = c.getTime();
	    Calendar c2 = Calendar.getInstance();
	    date2.setMonth(date2.getMonth()+1);
	    c2.setTime(date2);
	    c2.set(Calendar.DAY_OF_MONTH, 1);
	    c2.add(Calendar.DAY_OF_MONTH, -1);
	    date2 = c2.getTime();
		return orderDao.getmonthProduct(date,date2);
	}
}
