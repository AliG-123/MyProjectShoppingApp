package com.cohort20.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cohort20.dao.UserDao;
import com.cohort20.service.UserService;
import com.cohort20.to.User;

@RestController
public class UserController {
	

		@RequestMapping("/getUserDetails/{uid}")
		public User getUser(@PathVariable String uid) throws Exception {
			
			UserService userService = new UserService();
			
			User user = userService.getUser(uid);
			
			return user;
		}
		
		@RequestMapping("/getAllUsers")
		public List<User> getUsers() throws Exception {
			
			UserDao userDao = new UserDao();
			
			List<User> users = userDao.getAllDBUsers();
			
			return users;
			
		}
	}
	
