package com.sise.shop.dao;

import java.util.Date;
import java.util.List;

import com.sise.shop.po.Order;
import com.sise.shop.po.OrderItem;

public interface OrderDao {
	public void insertOrder(Order order);//添加订单
	public void updateOrder(Order order);//更新
	public void deleteOrder(Integer id); //删除
	public Order findOrderByid(Integer id); //根据id查找
	public List<Order> findOrderByUserid(Integer id,int page,int pageSize); //根据用户id查找指定页数数据
	public int getCountOrderByUserid(Integer id); //根据用户id获取所有的订单数
	
	public List<Order> findAllOrder(int page,int pageSize); //查找指定页数数据
	public int getCountAllOrder(); //获取所有的订单数
	
	public List<Order> findOrderByUseridOrstate(int id, int osid, int curPage,
			int pageSize);
	
	public int getCountOrderByUseridOrstate(int id, int osid);
	public List<OrderItem> getAllstates();
	
	public int getCountOrderByUseridAndStateid(Integer id,Integer osid); //根据用户id和订单状态id获取所有的订单数
	public Object getCountOrderPriceByUserid(int id);//统计消费总额
	public Object getCountOrderProductByUserid(int id);//统计购买数量
	public double getmonthPriceByUserid(int id,Date d1,Date d2);//统计某月份消费总额
	public int getmonthProductByUserid(int id,Date d1,Date d2);//统计某月份购买数量
	
	public Object getCountOrderPrice();
	public Object getCountOrderProduct();
	public double getmonthPrice(Date date, Date date2);
	public int getmonthProduct(Date date, Date date2);
}
