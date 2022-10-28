package com.cohort20.service;

import com.cohort20.dao.ProductDao;
import com.cohort20.dao.UserDao;
import com.cohort20.to.Product;
import com.cohort20.to.User;

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
	public Product replenishStock(Product product, int productID) throws Exception{
		ProductDao productdao = new ProductDao();
		product = productdao.selectProduct(productID);
		productdao.replenishStock(product, productID);
	 return product;
	}
	public void saveProduct(Product product) throws Exception {

		ProductDao productDao = new ProductDao();

		productDao.createProduct(product);

		}
}
