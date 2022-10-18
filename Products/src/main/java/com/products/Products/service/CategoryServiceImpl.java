package com.products.Products.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Products.entity.Category;
import com.products.Products.entity.Product;
import com.products.Products.repo.CategoryRepo;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category viewCatgeory(String cat) {
		System.out.println(categoryRepo.findByCategoryName(cat) + "**********************");
		return categoryRepo.findByCategoryName(cat);
	}

	

}
