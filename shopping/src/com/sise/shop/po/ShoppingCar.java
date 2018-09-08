package com.sise.shop.po;

public class ShoppingCar {
	private Integer id;
    private double productprice;
    private int counts;
    private Product product;
    private User user;
    public ShoppingCar(){
    	
    }
    public ShoppingCar(int productprice,int counts){
    	     
    	      this.productprice=productprice;
    	      this.counts=counts;
    	
    }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
