package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	
	
	@Autowired
	private ProductRepository repo;
	
	
	@Override
	@Transactional
	public Product saveProduct(Product product) {
		
		return repo.save(product); 
	}

	
	@Override
	@Transactional
	@CachePut(value = "product-cache",key="#product.prodId")
	public Product updateProduct(Product product) {
		return repo.save(product);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "product-cache",key="#prodId")
	public Product getProductById(Integer prodId) {
		Optional<Product> c= repo.findById(prodId);
		return c.isPresent()?c.get():null;
	}

	
	
	@Override
	@Transactional
	@CacheEvict(value = "product-cache",key="#prodId")	
	public void deleteProductById(Integer prodId) {
		repo.deleteById(prodId);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	
	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}

	
	@Override
	public Double calculateDiscount(Double cost, Double disc) {
		Double dCost = cost*disc/100.0;
		Long value = Math.round(cost-dCost);
		return value.doubleValue();
	}
	
	
}
