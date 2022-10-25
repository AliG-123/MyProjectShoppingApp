package com.cohort20.service;

import com.cohort20.dao.UserDao;
import com.cohort20.to.User;

public class UserService {

public User getUser(String uid) throws Exception {
		
		UserDao userDao = new UserDao();
		
		User user = userDao.getUserFromDB(uid);
		
		return user;
	}
//public void saveUser(String username, String Password, String firstName, String lastName, String email) throws Exception {
//	
//	UserDao userDao = new UserDao();
//	
//	userDao.createUser(username, Password, firstName, lastName, email);;
//
//}

public void saveUser(User user) throws Exception {

UserDao userDao = new UserDao();

userDao.createUser(user);

}
public User login(String username, String password) throws Exception {
	
	UserDao userDao = new UserDao();
	
	User user = userDao.loginSuccess(username, password);
	
	return user;
}
public User getUserDetail(String username, String password) throws Exception {
	UserDao userDao = new UserDao();
	User user = userDao.getUser(username, password);
	return user;
}
public void deleteUser(String username) throws Exception {
	UserDao userDao = new UserDao();
	userDao.deleteUserrow(username);
}
public void updateUser(String password, String firstName,String email, String username) throws Exception {
	UserDao userDao = new UserDao();
	userDao.updateUserInfo(password, firstName, email, username);

}
public void updateUserBalance(Double accountBalance, String username) throws Exception {
	UserDao userDao = new UserDao();
	userDao.updateAccountBalance(accountBalance, username);

}
}