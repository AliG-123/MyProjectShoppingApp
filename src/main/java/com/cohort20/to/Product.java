package com.cohort20.to;

public class Product {
	int productID;
	String name;
	double price;
	int unitCount;

	Product() {
	}

	public Product(int productID) {
		this.productID = productID;
	}

	public Product(int productID, int unitCount) {
		this.productID = productID;
		this.unitCount = unitCount;
	}

	public Product(int productID, String name, double price, int unitCount) {
		super();
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.unitCount = unitCount;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}

}
