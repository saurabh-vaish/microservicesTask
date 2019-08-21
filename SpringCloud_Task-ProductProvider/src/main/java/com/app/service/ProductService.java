package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public Product updateProduct(Product product);
	public Product getProductById(Integer id);
	public void deleteProductById(Integer id);
	public List<Product> getAllProducts();
	
	public boolean isExist(Integer id);
	
	public Double calculateDiscount(Double cost,Double disc);
	
	
}
