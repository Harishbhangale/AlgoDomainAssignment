package com.products.Products.service;

import com.products.Products.entity.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	
	Product updatedProduct(Product product,Integer pId);
	
	Product viewProduct(Integer pId);
	
	void deleteProduct(Integer pId);
	

}
