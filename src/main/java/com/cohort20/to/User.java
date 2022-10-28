package com.cohort20.to;

public class User {
	String username;
	String password;
	String firstName;
	String email;
	double accountBalance = 100;
	String role;
	
	
	User(){
		
	}


	public User(String username, String password, String firstName, String email) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
	}


	public User(String username, String password, String firstName, String email, double accountBalance) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
		this.accountBalance = accountBalance;
	}


	public User(String username, String password, String firstName, String email, String role, double accountBalance) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
		this.role = role;
		this.accountBalance = accountBalance;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	
}
