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
	public class UserController{

//		@RequestMapping("/firstPage")
//		public String getHomePage() {
//			
//			return "index";
//		}

		
		

		// This post method registers a user using the form inputs on the resigration.jsp
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView register(User user) throws Exception {
			user.setAccountBalance(100);
			UserService userservice = new UserService();
			userservice.saveUser(user);

			ModelAndView modelAndView = new ModelAndView("registration");
			modelAndView.addObject("AccountCreatedMessage", "Account Created");
			return modelAndView;
		}

		// This post method logs in a user using the form inputs on the index.jsp
		@PostMapping("/login")
		public static ModelAndView login(String username, String password, HttpSession session, Model model)
				throws Exception {

			UserService userService = new UserService();

			User user = userService.login(username, password);

			//The code checks if the user than logs in is a normal user or admin and it takes them to different pages respectively
			//A session is also created for the user and the session stores the User logged in so they can nagivate around the website without losing details
			if (user != null && user.getRole().equals("user")) {
				ModelAndView modelAndView = new ModelAndView("welcome");
				modelAndView.addObject("fname", user.getFirstName());
				modelAndView.addObject("email", user.getEmail());
				modelAndView.addObject("username", user.getUsername());
				modelAndView.addObject("accountBalance", user.getAccountBalance());
				session.setAttribute("user", user);
				return modelAndView;
			}else if (user != null && user.getRole().equals("admin")){
				ModelAndView modelAndView = new ModelAndView("adminpage");
				session.setAttribute("user", user);
				return modelAndView;
			}
			else {
				ModelAndView modelAndView = new ModelAndView("index");
				modelAndView.addObject("LoginErrorMessage", "Wrong Credentials");
				return modelAndView;
			}
		}
		//The session only loses the user data after the user/admin clicks logout
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		//This mapping is used to navigate back to the welcome/admin page when the user is logged in it is dependant on is user is a normal user or admin
		@GetMapping("/welcome")
		public String welcome(HttpSession session) {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				return "index";
			}else if (user.getRole().equals("admin")) {
				return "adminpage";
			}else {
				return "welcome";
			}
		}
		//THis mapping link can be used to check the current user logged in to see if there is anything in the session
		@GetMapping("/info")
		public String userInfo(HttpSession session) {
			return "user";
		}
		
		//Takes you to account balance page
		@GetMapping("/accountbalance")
		public String balancePage(HttpSession session) throws Exception {
			return "accountbalance";
		}
		
		//takes you to delete account page
		@RequestMapping("/deleteaccountpage")
		public String DELETE(HttpSession session) throws Exception {
			return "deletion";
		}
		
		//performs the delete account method
		@PostMapping("/deleteaccount")
		public ModelAndView DeleteAccount(HttpSession session, String password) throws Exception {
			User user = (User)session.getAttribute("user");
			ModelAndView modelAndView1 = new ModelAndView("delete");
			ModelAndView modelAndView = new ModelAndView("deletion");
			if (user.getPassword().equals(password)) {
				UserService userservice = new UserService();
				userservice.deleteUser(user.getUsername());
//				modelAndView.addObject("AccountDeleted", "Your account has been deleted");
				return modelAndView1;
			}else {
				modelAndView.addObject("IncorrectPassword", "Sorry that is the incorrect password");
			return modelAndView;
			}
		}
		//takes you to changeaccountdetails page
		@RequestMapping("/changedetails")
		public String changeDetails() {

			return "changeaccountdetails";
		}
		
		//performs the changes to the account depending on form fields entered
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
			modelAndView.addObject("accountUpdated", "Your account has been updated");
			return modelAndView;
		}

		//takes you to shopping page
		@GetMapping("/shop")
		public String shopping() {
			return "shop";
		}

		//performs a buying operation when the user buys something from the shop
		@PostMapping ("/buy")
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
		//This mapping takes you to an admin page when user logs in as an admin -- method is seen later
//			@RequestMapping("/adminpage")
//			public String admin() {
//				
//				return "adminpage";
//			}
		
		//Within admin account the admin can view all users in DB by clicking view users which uses this mapping to return viewusers.jsp
			@RequestMapping("/viewallusers")
			public String viewUsers() {
				
				return "viewusers";
			}
			
		
		//This mapping is the action performed when admin clicks change role on viewusers page. It changes role from user to admin or admin to user depending on current role.
		@PostMapping("/updateUserRole")
		public ModelAndView updateRoles(String username) throws Exception {
			UserService userService = new UserService();
			userService.updateUserRole(username);
				ModelAndView modelandview = new ModelAndView("viewusers");
				modelandview.addObject("roleUpdated", username + "'s role has been updated");
				return modelandview;
			} 
		
		
		}

	

//		@RequestMapping("/getUserDetails/{uid}")
//		public User getUser(@PathVariable String uid) throws Exception {
//			
//			UserService userService = new UserService();
//			
//			User user = userService.getUser(uid);
//			
//			return user;
//		}
		
//		@RequestMapping("/getAllUsers")
//		public List<User> getUsers() throws Exception {
//			
//			UserDao userDao = new UserDao();
//			
//			List<User> users = userDao.getAllDBUsers();
//			
//			return users;
//			
//		}
//	}
	
