package com.sise.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sise.shop.dao.ProductDao;
import com.sise.shop.po.Product;
import com.sise.shop.service.ProductService;
import com.sise.shop.vo.Pager;

@Transactional(readOnly=false)
public class ProductServiceImpl implements ProductService {
	@Resource private ProductDao productDao;
	@Override
	public Product getProductById(Integer id) {
	
		return productDao.findProductById(id);
	}

	@Override
	public void addSProduct(Product product) {
	
		productDao.addProduct(product);
	}

	@Override
	public void updateSProduct(Product product) {
		
		productDao.updateProduct(product);
	}

	@Override
	public void deleteSProduct(Integer id) {
		
		productDao.deleteProductById(id);
	}

	@Override
	public List<Product> findAllProduct(int page,int pageSize) {
	
		return productDao.getAllProduct(page,pageSize);
	}

	@Override
	public List<Product> getSProductByCatagoryId(int type ,int page,int pageSize) {
		
		return productDao.getProductByCatagoryId(type,page,pageSize);
	}
	
	@Override
	public List<Product> findSProductByName(String keyword,int page,int pageSize) {
		
		return productDao.getProductByName(keyword,page,pageSize);
	}

	@Override
	public Pager getPagerOfAllProduct(int pageSize) {
		
		int count = productDao.getCountOfAllProduct();
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public Pager getPagerSProductByCatagoryId(int type, int pageSize) {
		
		int count = productDao.getCountProductByCatagoryId(type);
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

	@Override
	public Pager findPagerSProductByName(String keyword, int pageSize) {
		
		int count = productDao.getCountProductByName(keyword);
		Pager pager  = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}

}
