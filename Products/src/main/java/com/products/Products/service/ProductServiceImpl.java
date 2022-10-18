package com.products.Products.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.products.Products.entity.Product;
import com.products.Products.repo.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public Product updatedProduct(Product product ,Integer pId) {
		Product dbProduct = productRepo.findById(pId).get();
		System.out.println(dbProduct + "************************");
		dbProduct.setProductPrice(product.getProductPrice());
		// TODO Auto-generated method stub
		return productRepo.save(dbProduct);
	}

	@Override
	public Product viewProduct(Integer pId) {
		// TODO Auto-generated method stub
		return productRepo.findById(pId).get();
	}

	@Override
	public void deleteProduct(Integer pId) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(pId).get();
		productRepo.delete(product);
	}

}
