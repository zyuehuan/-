package com.sise.shop.service;

import java.util.Date;
import java.util.List;

import com.sise.shop.po.Order;
import com.sise.shop.po.OrderItem;
import com.sise.shop.vo.Pager;

public interface OrderService {
	public void addOrder(Order order);//添加订单
	public void updateSOrder(Order order);//更新
	public void deleteSOrder(Integer id); //删除
	public Order findSOrderByid(Integer id); //根据id查找
	public List<Order> findSOrderByUserid(Integer id,int page,int pageSize); //根据用户id查找指定页数数据
	public Pager getPagerOfOrderByUserid(int id,int pageSize);
	
	public List<Order> findSAllOrder(int page,int pageSize); //查找指定页数数据
	public Pager getPagerOfAllOrder(int pageSize);
	
	public List<Order> findSOrderByUseridOrstate(int id, int osid, int curPage, int pageSize);
	public Pager getPagerOfOrderByUseridOrstate(int id, int osid, int pageSize);
	public List<OrderItem>fingSAllstates();
	public int findSOrderByUserid(Integer id);
	public int findSOrderByUseridAndStateid(Integer id, Integer i);
	public Object findCountOrderPriceByUserid(Integer id);
	public Object findCountOrderProductByUserid(Integer id);
	public double findmonthPriceByUserid(Integer id, Date date, Date date2);
	public int findmonthProductByUserid(Integer id, Date date, Date date2);
	
	public Object findCountOrderPrice();
	public Object findCountOrderProduct();
	public double findmonthPrice(Date date, Date date2);
	public int findmonthProduct(Date date, Date date2);
	
	
}
