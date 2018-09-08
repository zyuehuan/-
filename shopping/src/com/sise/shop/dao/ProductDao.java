package com.sise.shop.dao;

import java.util.List;

import com.sise.shop.po.Product;

public interface ProductDao {



	public Product findProductById(Integer id);

	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProductById(Integer id);

	public List<Product> getAllProduct(int page, int pageSize);

	public List<Product> getProductByCatagoryId(int type, int page,
			int pageSize);

	public List<Product> getProductByName(String keyword, int page,
			int pageSize);

	public int getCountOfAllProduct();

	public int getCountProductByCatagoryId(int type);

	public int getCountProductByName(String keyword);

}
