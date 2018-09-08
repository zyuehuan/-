package com.sise.shop.po;

import java.util.HashSet;
import java.util.Set;



public class Product {
	private int id;
    private String name;
    private String description;
    private String keyword;
    private double price;
    private int counts;
    private int type;
    private String path;
   
    private Set<OrderItem> orderitems = new HashSet<OrderItem>();
    
    public Product(){
    	
    }
    public Product(String name,String description,String keyword,double price,int counts,int type,String path){
    	       this.name=name;
    	       this.description=description;
    	       this.keyword=keyword;
    	       this.price=price;
    	       this.counts=counts;
    	       this.type=type;
    	       this.path=path;
    	      
    }
	    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description
				+ ", price=" + price + ",  counts" + counts
				+ ", type" + type + "]";
	}
		
}
