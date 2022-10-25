package com.cohort20;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cohort20.db.DBUtils;
import com.cohort20.to.User;


@RestController
public class First {
	
	@RequestMapping("/message")
	public String getMessage() {
		return "Hello SpringBoot Developers : ";
	}
	
	@RequestMapping("/getTodayWeather")
	public String getWeather() {
		return "Today, the weather will be really cold...";
	}
//	@RequestMapping("/getUser")
//	public List<User> getUser(){
//		List<User> users = new ArrayList<User>();
//		users.add(new User("Alig123", "ali123", "ali", "ali@gmail.com"));
//		users.add(new User("Jabril123", "Password" ,"Jabril", "jabril@gmail.com"));
//		users.add(new User("Gedas123", "GedasPassword ","Gedas", "gedas@gmail.com"));
//		
//		return users;
//	}
	
//	@RequestMapping("/getDatabaseUsers")
//	public List<User> getDatabaseUsers() throws Exception {
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("select * from users");
//		ResultSet rs = pstmt.executeQuery();
//		List<User> users= new ArrayList<User>();
//		while (rs.next()) {
//			users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//		}
//		return users;
//		
//	}
	
//	@RequestMapping("users/getUserDB/{uid}")
//	public User getUserDB(@PathVariable String uid) throws Exception {
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ?");
//		pstmt.setString(1, uid);
//		ResultSet rs = pstmt.executeQuery();
////		List<User> users= new ArrayList<User>();
//		User user = null;
//		if (rs.next()) {
//			user = (new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//		}
//		return user;
		
	}
	

