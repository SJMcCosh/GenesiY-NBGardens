package com.genesisY.nbGardens.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.LoginService;

@Named("login")
@RequestScoped
public class LoginController{

	@Inject
	private LoginService passcheck;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private CustomerController customerController;
	private String username = "";
	private String password = "";
	private String error = "";

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

	public String gotoSignUp() {
		return "signup";
	}
	
	private boolean userValidate(String username) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z_]+$");
		Matcher matcher = pattern.matcher(username);
		if (username.length() > 7 && username.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}
	
	public String login() {
		if (userCredentials.getAttempts()>2){
			System.out.println(userCredentials.getAttempts());
			return "index";
		};
		if (username.equals("")) {
			error = "Please enter a username";
			password = "";
			userCredentials.setAttempts(userCredentials.getAttempts()+1);
			return "loginpage";
		}
		else if (password.equals("")) {
			error = "Please enter a password";
			password = "";
			userCredentials.setAttempts(userCredentials.getAttempts()+1);
			return "loginpage";
		}
		else if (!userValidate(username)){
			userCredentials.setAttempts(userCredentials.getAttempts()+1);
			return "loginpage";
		}
		else if (passcheck.passCheck(username, password)) {
			userCredentials.setUsername(username);
			userCredentials.setLoggedin(true);
			userCredentials.setAttempts(0);
			return customerController.viewDetails();
		} else {
			error = "Invalid username and password";
			username = "";
			password = "";
			userCredentials.setAttempts(userCredentials.getAttempts()+1);
			return "loginpage";
		}
	}
	
	public boolean isLoggedIn(){
		return userCredentials.isLoggedin();
	}
	
	public String logout(){
		userCredentials.setUsername(null);
		userCredentials.setLoggedin(false);
		return "index";
	}
}
