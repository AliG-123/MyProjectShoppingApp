package com.cohort20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cohort20.service.UserService;
import com.cohort20.to.User;

@Controller
public class PracticeController {

	@RequestMapping("/index")
	public String indexPage() {
		return "index";
	}


//	@RequestMapping("/welcome")
//		public String welcomePage() {
//			return "welcome";
//		}
	
//	@RequestMapping("/welcome")
//	public ModelAndView welcome() throws Exception {
//		ModelAndView modelAndView = new ModelAndView("welcome");
//		UserService userService = new UserService();
//		
//		User user = userService.getUserDetail("alig123","pass");
//	
//		modelAndView.addObject("fname", user.getFirstName());
//		return modelAndView;
//	}
	}