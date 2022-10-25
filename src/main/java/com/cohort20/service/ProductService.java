package com.cohort20.service;

import com.cohort20.dao.ProductDao;
import com.cohort20.to.Product;

public class ProductService {
	public Product checkProductStock(Product product, int productID) throws Exception{
		ProductDao productdao = new ProductDao();
		product = productdao.selectProduct(productID);
	 return product;
	}	
	public Product updateProductStock(Product product, int productID) throws Exception{
		ProductDao productdao = new ProductDao();
		product = productdao.selectProduct(productID);
		productdao.updateStock(product, productID);
	 return product;
	}	
}
