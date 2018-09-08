package com.sise.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.shop.dao.ShoppingCarDao;
import com.sise.shop.po.Product;
import com.sise.shop.po.ShoppingCar;

public class ShoppingCarDaoImpl extends HibernateDaoSupport implements ShoppingCarDao {

	@Override
	public ShoppingCar getShoppingCar(int userId, int productId) {
		ShoppingCar shoppingCar = (ShoppingCar) getHibernateTemplate().find("from ShoppingCar as s where s.userid like '%"+userId+"%' and p.productid="+productId);
		return shoppingCar;
	}

	@Override
	public void addShoppingCar(ShoppingCar shoppingCar) {
		getHibernateTemplate().persist(shoppingCar);

	}

	@Override
	public void deleteShoppingCar(int userId, int productId) {
		ShoppingCar shoppingCar = (ShoppingCar) getHibernateTemplate().find("from ShoppingCar as s where s.userid like '%"+userId+"%' and p.productid="+productId);
		getHibernateTemplate().delete(shoppingCar);
	}

	@Override
	public void updateShoppingCar(ShoppingCar shoppingCar) {
		getHibernateTemplate().update(shoppingCar);

	}

	@Override
	public List<ShoppingCar> getShoppingCars(int userId) {
		List<ShoppingCar> shoppingCars = (List<ShoppingCar>) getHibernateTemplate().find("from ShoppingCar as s where s.userId = "+userId);
		return shoppingCars;
	}

}
