package com.cohort20.controller;

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
public class HomeController {

//	@RequestMapping("/firstPage")
//	public String getHomePage() {
//		
//		return "index";
//	}

	@RequestMapping("/") // forward slash "/" in the RequestMapping suggests the system to execute API if
							// there is nothing in the URL
							// except the "localhost:8081". So we follow this way if you have decided any
							// API needs to be executed and rendering
							// index or Home page in response to user...
	public String getHomePage() {
		System.out.println("inside getHomepage()");
		return "index";
	}

	//This mapping takes you to registration page when user clicks register instead of login
	@RequestMapping("/registrationPage")
	public String registrationPage() {

		return "registration";
	}
}
	

	