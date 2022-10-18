package com.products.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.Products.Utils.FinalPriceCalculator;
import com.products.Products.Utils.FinalPrice;
import com.products.Products.entity.Product;
import com.products.Products.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FinalPriceCalculator calculator;
	
	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		System.out.println("Product ***********    " + product);
		return productService.addProduct(product);
	}
	
	@PostMapping("/{productId}")
	public Product updateProduct(@RequestBody Product product,@PathVariable Integer productId) {
		System.out.println("Product ***********    " + product);
		return productService.updatedProduct(product,productId);
	}

	@GetMapping("/{productId}")
	public Product viewProduct(@PathVariable Integer productId) {
		return productService.viewProduct(productId);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		productService.deleteProduct(productId);
		return "Product deleted successfully";
	}
	
	@GetMapping("/price/{productId}")
	public FinalPrice finalPrice(@PathVariable Integer productId) {
		return calculator.calculateFinalPrice(productId);
	}
}
