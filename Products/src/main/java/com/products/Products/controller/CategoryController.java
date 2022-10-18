package com.products.Products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.Products.entity.Category;
import com.products.Products.service.CategoryService;

@RestController
@RequestMapping("/catagory")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category addProduct(@RequestBody Category catagory) {
		System.out.println("Product ***********    " + catagory);
		return categoryService.addCategory(catagory);
	}
	
	
	@GetMapping("/{cat}")
	public Category viewCat(@PathVariable String cat) {
		return categoryService.viewCatgeory(cat);
	}
}
