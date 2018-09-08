package com.sise.shop.service;

import java.util.List;

import com.sise.shop.po.Product;
import com.sise.shop.vo.Pager;

public interface ProductService {

	public void addSProduct(Product product);

	

	public Product getProductById(Integer pid);

	public void updateSProduct(Product product);

	public void deleteSProduct(Integer nid);

	public List<Product> findAllProduct(int curPage, int i);

	public Pager getPagerOfAllProduct(int i);

	public List<Product> getSProductByCatagoryId(int type, int curPage, int i);

	public Pager getPagerSProductByCatagoryId(int type, int i);

	public List<Product> findSProductByName(String keyword, int curPage,
			int i);

	public Pager findPagerSProductByName(String keyword, int i);





}
