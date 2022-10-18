package com.products.Products.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Products.entity.Category;
import com.products.Products.entity.Product;
import com.products.Products.repo.CategoryRepo;
import com.products.Products.repo.ProductRepo;
import com.products.Products.service.ProductService;

@Service
public class FinalPriceCalculator {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	
	public FinalPrice calculateFinalPrice(Integer pId) {
		
		Product product = productRepo.findById(pId).get();
		System.out.println(product);
		String categoryName = product.getCategory().getCategoryName();
		Category catgeoryByName = categoryRepo.findByCategoryName(categoryName);
		System.out.println(catgeoryByName);
		double discountPrice = ( product.getProductPrice() * catgeoryByName.getDis() ) / 100;
		double gstPrice = (product.getProductPrice() * catgeoryByName.getGst() ) / 100;
		double finalPrice = (product.getProductPrice() - discountPrice) + gstPrice + catgeoryByName.getDelCharge();
		System.out.println(discountPrice + "***" + gstPrice + "*****" + finalPrice);
		FinalPrice dto = new FinalPrice();
		
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setProductType(product.getProductType());
		dto.setCategoryName(catgeoryByName.getCategoryName());
		dto.setBasePrice(product.getProductPrice());
		dto.setDiscount(discountPrice);
		
		Charges charges = new Charges();
		charges.setGst(gstPrice);
		charges.setDelCharges(catgeoryByName.getDelCharge());
		
		dto.setCharges(charges);
		dto.setPrice(finalPrice);
		
		return dto;
	}
}
