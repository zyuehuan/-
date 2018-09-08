package com.sise.shop.po;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String address;
	private String email;
	private String phone;
	private Set<ShoppingCar> shoppingcar = new HashSet<ShoppingCar>();
	private Set<Order> orders= new HashSet<Order>();
	//private Set<Order> orders= new HashSet<Order>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String email, String password,
			String phone,String sex,String address) {
		super();
		this.username = username;
		this.password = password;	
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public User(String username, String email,
			String phone,String sex,String address) {
		super();
		this.username = username;	
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<ShoppingCar> getShoppingcar() {
		return shoppingcar;
	}

	public void setShoppingcar(Set<ShoppingCar> shoppingcar) {
		this.shoppingcar = shoppingcar;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	/*
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	*/
	@Override
	public String toString() {
		return "News [id=" + id + ", username=" + username + ", password=" + password
				+ ",  sex=" + sex + ", address=" + address 
				+", email" + email + ", phone" + phone  + "]";
	}

	
	
}
