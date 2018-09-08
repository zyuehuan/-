package com.sise.shop.dao.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.shop.dao.ProductDao;
import com.sise.shop.po.Product;


public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	@Override
	public Product findProductById(Integer id) {
	
		Product product = getHibernateTemplate().get(Product.class, id);
		return product;
	}

	
	@Override
	public void addProduct(Product product) {
		
		getHibernateTemplate().persist(product);
	}

	

	@Override
	public void updateProduct(Product product) {
		
		getHibernateTemplate().saveOrUpdate(product);
	}

	

	@Override
	public void deleteProductById(Integer id) {
		
		Product product = getHibernateTemplate().get(Product.class, id);
		getHibernateTemplate().delete(product);
	}

	

	@Override
	public List<Product> getAllProduct(final int page,final int pageSize){
		// TODO Auto-generated method stub
		List<Product> products = null;
				//(List<News>) getHibernateTemplate().find("from News");
		try {
			products = this.getHibernateTemplate().execute(
			new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException {
			Query query = session.createQuery("from Product");
			query.setFirstResult(pageSize*(page-1));
			query.setMaxResults(pageSize);
			List productss = query.list();
			return productss;
			}
			});
			} catch (Exception e) {
			throw e;
			}
		return products;
	}


	@Override
	public List<Product> getProductByCatagoryId(final int type,final int page,final int pageSize) {
		// TODO Auto-generated method stub
		//List<News> newses = (List<News>) getHibernateTemplate().find("from News as n where n.category.id = "+id);
		List<Product> products = null;
try {
	products = this.getHibernateTemplate().execute(
	new HibernateCallback() {
	public Object doInHibernate(Session session)
	throws HibernateException {
	Query query = session.createQuery("from Product as p where p.type = "+type);
	query.setFirstResult(pageSize*(page-1));
	query.setMaxResults(pageSize);
	List productss = query.list();
	return productss;
	}
	});
	} catch (Exception e) {
	throw e;
	}
		return products;
	}

	
	@Override
	public List<Product> getProductByName(final String keyword,final int page,final int pageSize) {
		// TODO Auto-generated method stub
		//List<News> newses = (List<News>) getHibernateTemplate().find("from News as n where n.title like '%"+title+"%' and n.category.id="+id);
		List<Product> products = null;
try {
	products = this.getHibernateTemplate().execute(
	new HibernateCallback() {
	public Object doInHibernate(Session session)
	throws HibernateException {
		Query query = session.createQuery("from Product as p where p.keyword like '%"+keyword+"%'");
	query.setFirstResult(pageSize*(page-1));
	query.setMaxResults(pageSize);
	List productss = query.list();
	return productss;
	}
	});
	} catch (Exception e) {
	throw e;
	}
		return products;
	}

	@Override
	public int getCountOfAllProduct() {
		// TODO �Զ���ɵķ������
		List<Product> products = (List<Product>) getHibernateTemplate().find("from Product");
		return products.size();
	}


	@Override
	public int getCountProductByCatagoryId(int type) {
		// TODO �Զ���ɵķ������
		List<Product> products = (List<Product>) getHibernateTemplate().find("from Product as p where p.type = "+type);
		return products.size();
	}


	@Override
	public int getCountProductByName(String keyword) {
		List<Product> products = (List<Product>) getHibernateTemplate().find("from Product as p where p.keyword like '%"+keyword+"%' ");
		return products.size();
	}


}
