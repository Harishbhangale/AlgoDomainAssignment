package com.products.Products.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@Column(name = "category_Name")
	private String categoryName;
	@Column(name = "discount")
	private int dis;
	@Column(name = "gst")
	private int gst;
	@Column(name = "delivery_charge")
	private int delCharge;
	

	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> productList = new ArrayList<>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int dis, int gst, int delCharge, String categoryName, List<Product> productList) {
		super();
		this.dis = dis;
		this.gst = gst;
		this.delCharge = delCharge;
		this.categoryName = categoryName;
		this.productList = productList;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

//	public String getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(String categoryId) {
//		this.categoryId = categoryId;
//	}

	public int getDis() {
		return dis;
	}

	public void setDis(int dis) {
		this.dis = dis;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	public int getDelCharge() {
		return delCharge;
	}

	public void setDelCharge(int delCharge) {
		this.delCharge = delCharge;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
