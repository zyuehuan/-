package com.sise.shop.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Order {
	private int oid;
	private Date time;
	private String remark;
	public float totalPrices;
	private int countproduct;
	private OrderState orderstate;
	private User user;
	private Set<OrderItem> orderitems = new HashSet<OrderItem>();
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(Date time) {
		super();
		this.time = time;

	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public OrderState getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(OrderState orderstate) {
		this.orderstate = orderstate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getTotalPrices() {
		return totalPrices;
	}
	public void setTotalPrices(float totalPrices) {
		this.totalPrices = totalPrices;
	}
	
	public int getCountproduct() {
		return countproduct;
	}
	public void setCountproduct(int countproduct) {
		this.countproduct = countproduct;
	}
	
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid
				+ ", time=" + time + ", remark=" + remark + " + " 
				+ ",  totalPrices" + totalPrices
				+ ", orderstate=" + orderstate + ", user=" + user+ "]";
	}
	
	
	
}
