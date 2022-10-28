package com.cohort20.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cohort20.db.DBUtils;
import com.cohort20.service.ProductService;
import com.cohort20.service.UserService;
import com.cohort20.to.Product;
import com.cohort20.to.User;
import com.mysql.cj.Session;


	@Controller

public class ProductController {
	
	//This mapping is the action performed when admin wishes to add a new product from addproduct page
			@PostMapping("createProduct")
			public ModelAndView productAdd(Product product) throws Exception {
				ProductService productService = new ProductService();
				productService.saveProduct(product);

				ModelAndView modelAndView = new ModelAndView("addproduct");
				modelAndView.addObject("ProductAdded", "Product: " + product.getName() + " added");
				return modelAndView;
			}
			
			//mapping takes you to add products page
			@RequestMapping("/addProduct")
			public String addProducts() {
				
				return "addproduct";
			}
		
			//Within admin account the admin can view stocks by clicking replenish stocks which uses this mapping to return stocks.jsp
			@RequestMapping("/stocks")
			public String stockUpdate() {
				
				return "stocks";
			}
			
		//This mapping is the action performed when admin clicks add stock on stocks page which adds 1 to unitCount
		@PostMapping("/replenishStock")
			public ModelAndView stockUpdated(Product product, int productID) throws Exception {
				ProductService productService = new ProductService();
				product = productService.replenishStock(product, productID);
					ModelAndView modelandview = new ModelAndView("stocks");
					modelandview.addObject("stockUpdated", product.getName() + " stock has been updated");
					return modelandview;
				} 

}
