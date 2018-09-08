package com.sise.shop.dao;

import java.util.List;

import com.sise.shop.po.ShoppingCar;

public interface ShoppingCarDao {

	public ShoppingCar getShoppingCar(int userId, int productId);

	public void addShoppingCar(ShoppingCar shoppingCar);

	public void deleteShoppingCar(int userId, int productId);

	public void updateShoppingCar(ShoppingCar shoppingCar);

	List<ShoppingCar> getShoppingCars(int userId);

}
