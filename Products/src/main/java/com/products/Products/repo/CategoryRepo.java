package com.products.Products.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.Products.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
	
	Category findByCategoryName(String cat);

}
