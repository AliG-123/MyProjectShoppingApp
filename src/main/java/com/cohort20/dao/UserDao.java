package com.cohort20.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cohort20.db.DBUtils;
import com.cohort20.to.User;

public class UserDao {
	public List<User> getAllDBUsers() throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from users");
		ResultSet rs = pstmt.executeQuery();
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6)));
		}
		return users;

	}

	public User getUserFromDB(String uid) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ?");
		pstmt.setString(1, uid);
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		if (rs.next()) {
			user = (new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6)));
		}
		return user;

	}

//	public void createUser(String username, String password, String firstName, String lastName, String email) throws Exception {
//		Connection conn = DBUtils.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement("insert into users values (?,?,?,?,?) ");
//		pstmt.setString(1, username);
//		pstmt.setString(2, password);
//		pstmt.setString(3, firstName);
//		pstmt.setString(4, email);
//		pstmt.setString(5, "user");
//		pstmt.execute();
//
//	}
	public void createUser(User user) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into users values (?,?,?,?,?,?) ");
		int balance = 100;
		user.setAccountBalance(balance);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getFirstName());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, "user");
		pstmt.setInt(6, balance);
		pstmt.execute();

	}

	public User loginSuccess(String username, String password) throws Exception {

		
		User user = null;

		Connection conn = DBUtils.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ? and password = ?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			user = (new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6)));
		}
		return user;
	}

	public User getUser(String username, String password) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ? and password = ?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		if (rs.next()) {
			user = (new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(6)));
		}
		return user;

	}
	public void deleteUserrow(String username) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from users where username = ?");
		pstmt.setString(1, username);
		pstmt.executeUpdate();
	}
	public void updateUserInfo(String password, String firstName,String email, String username) throws Exception {
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("update users set firstName = ?, password = ?, email = ? where username = ?");
		pstmt.setString(1, firstName);
		pstmt.setString(2, password);
		pstmt.setString(3, email);
		pstmt.setString(4, username);
		pstmt.executeUpdate();
	}
		
	public void updateAccountBalance(Double accountBalance, String username) throws Exception {
			Connection conn = DBUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update users set accountBalance = ? where username = ?");
			pstmt.setDouble(1, accountBalance);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
	}
		
		
}

