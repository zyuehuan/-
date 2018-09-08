package com.sise.shop.po;

import java.util.HashSet;
import java.util.Set;

public class OrderState {
	private int osid;
	private String orderstate;
	private Set<Order> orders= new HashSet<Order>();
	public OrderState() {
		// TODO Auto-generated constructor stub
	}
	public OrderState(String orderstate) {
		super();
		this.orderstate = orderstate;	
	}
	public int getOsid() {
		return osid;
	}
	public void setOsid(int osid) {
		this.osid = osid;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "OrderState [osid=" + osid + ", orderstate=" + orderstate + "]";
	}
	
}
