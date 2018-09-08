package com.sise.shop.service;

import java.util.List;

import com.sise.shop.po.ShoppingCar;

public interface ShoppingCarService {

	  public ShoppingCar getShoppingCar(int userId, int productId);

	    public void addShoppingCar(ShoppingCar shoppingCar);

	    public void deleteShoppingCar(int userId,int productId);

	    public void updateShoppingCar(ShoppingCar shoppingCar);

	    public List<ShoppingCar> getShoppingCars(int userId);

}
