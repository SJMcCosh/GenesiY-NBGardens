package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.LoginService;

@Named("login")
@RequestScoped
public class LoginController{

	@Inject
	private LoginService passcheck;
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
	
	public String login() {
		
		if (username.equals("")) {
			error = "Please enter a username";
			password = "";
			return "loginpage";
		}
		else if (password.equals("")) {
			error = "Please enter a password";
			password = "";
			return "loginpage";
		}
		else if (passcheck.passCheck(username, password) == true) {
			return "index";
		} else {
			error = "Invalid username and password";
			username = "";
			password = "";
			return "loginpage";
		}
	}
}
