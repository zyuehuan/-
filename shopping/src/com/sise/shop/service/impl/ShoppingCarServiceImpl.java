package com.sise.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sise.shop.dao.ShoppingCarDao;
import com.sise.shop.po.ShoppingCar;
import com.sise.shop.service.ShoppingCarService;

public class ShoppingCarServiceImpl implements ShoppingCarService {
	  @Resource
	  private ShoppingCarDao shoppingCarDao;
	    @Override
	    public ShoppingCar getShoppingCar(int userId, int productId) {
	        return shoppingCarDao.getShoppingCar(userId,productId);
	    }

	    @Override
	    public void addShoppingCar(ShoppingCar shoppingCar) {
	        shoppingCarDao.addShoppingCar(shoppingCar);
	    }

	    @Override
	    public void deleteShoppingCar(int userId, int productId) {
	         shoppingCarDao.deleteShoppingCar(userId,productId);
	    }

	    @Override
	    public void updateShoppingCar(ShoppingCar shoppingCar) {
	         shoppingCarDao.updateShoppingCar(shoppingCar);
	    }

	    @Override
	    public List<ShoppingCar> getShoppingCars(int userId) {
	        return shoppingCarDao.getShoppingCars(userId);
	    }

}
