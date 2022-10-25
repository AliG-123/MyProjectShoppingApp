package com.cohort20.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment2", "root", "admin123");
		return conn;
	}

}
