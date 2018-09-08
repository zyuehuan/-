package com.sise.shop.po;

public class OrderItem {
	private int id;
	private int number;	
	
	private Order order;
	private Product product;
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	public OrderItem( int number) {
		super();
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", number=" + number+ "]";
	}
	
}
