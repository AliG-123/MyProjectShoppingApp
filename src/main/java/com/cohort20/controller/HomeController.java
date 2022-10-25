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

	@RequestMapping("/registrationPage")
	public String registrationPage() {

		return "registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(User user) throws Exception {
		user.setAccountBalance(100);
		UserService userservice = new UserService();
		userservice.saveUser(user);

		System.out.println("User Created: Username = " + user.getUsername());
//		System.out.println(user.getUsername()", "+password+", "+lastName+", "+firstName+", "+email);

		ModelAndView modelAndView = new ModelAndView("registration");
		modelAndView.addObject("AccountCreatedMessage", "Account Created");
		return modelAndView;
	}

	@PostMapping("/login")
	public static ModelAndView login(String username, String password, HttpSession session, Model model)
			throws Exception {

		System.out.println("inside login" + username + ",  " + password);

//		UserDAO userDao = new UserDAO();
//		
//		boolean loginStatus = userDao.loginSuccess(username, password);

		UserService userService = new UserService();

		User user = userService.login(username, password);

		if (user != null) {
			ModelAndView modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("fname", user.getFirstName());
			modelAndView.addObject("email", user.getEmail());
			modelAndView.addObject("username", user.getUsername());
			modelAndView.addObject("accountBalance", user.getAccountBalance());
			session.setAttribute("user", user);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("LoginErrorMessage", "Wrong Credentials");
			return modelAndView;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/welcome")
	public String welcome(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "index";
		} else {
			return "welcome";
		}
	}

	@GetMapping("/info")
	public String userInfo(HttpSession session) {
		return "user";
	}

	@GetMapping("/accountbalance")
	public String balancePage(HttpSession session) throws Exception {
		return "accountbalance";
	}

	@RequestMapping("/deleteaccountpage")
	public String DELETE(HttpSession session) throws Exception {
		return "deletion";
	}
	@PostMapping("/deleteaccount")
	public ModelAndView DeleteAccount(HttpSession session, String password) throws Exception {
		User user = (User)session.getAttribute("user");
		ModelAndView modelAndView1 = new ModelAndView("delete");
		ModelAndView modelAndView = new ModelAndView("deletion");
		if (user.getPassword().equals(password)) {
			UserService userservice = new UserService();
			userservice.deleteUser(user.getUsername());
//			modelAndView.addObject("AccountDeleted", "Your account has been deleted");
			return modelAndView1;
		}else {
			modelAndView.addObject("IncorrectPassword", "Sorry that is the incorrect password");
		return modelAndView;
		}
	}

	@RequestMapping("/changedetails")
	public String changeDetails() {

		return "changeaccountdetails";
	}

	@PostMapping("/accountUpdated")
	public ModelAndView updateAccount(HttpSession session, String password, String firstName, String email)
			throws Exception {
		User user = (User)session.getAttribute("user");
		UserService userservice = new UserService();
		userservice.updateUser(password, firstName, email, user.getUsername());
		user.setFirstName(firstName);
		user.setEmail(email);
		user.setPassword(password);

		ModelAndView modelAndView = new ModelAndView("changeaccountdetails");
		modelAndView.addObject("accountUpdated", "Your account has been updated: ");
		return modelAndView;
	}

	@GetMapping("/shop")
	public String shopping() {
		return "shop";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ModelAndView itemsBought(HttpSession session, int productID, Product product) throws Exception {
		ProductService productService = new ProductService();
		Product product1 = productService.checkProductStock(product, productID);
		if (product1.getUnitCount() < 1) {
			ModelAndView modelandview = new ModelAndView("shop");
			modelandview.addObject("OutofStock", "Sorry item is out of stock");
			return modelandview;
		} else {
			product = productService.updateProductStock(product, productID);
			User user = (User) session.getAttribute("user");
			UserService userService = new UserService();
			userService.updateUserBalance((user.getAccountBalance() - product.getPrice()), user.getUsername());
			user.setAccountBalance(user.getAccountBalance() - product.getPrice());
			ModelAndView modelandview = new ModelAndView("shop");
			String productName = product.getName();
			modelandview.addObject("ItemBought", "You have purchased " + productName);
			return modelandview;
		}

	}
}
