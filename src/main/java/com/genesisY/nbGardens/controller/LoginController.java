package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.LoginService;

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

	public String login() {
		boolean bool = passcheck.passCheck(username, password);
		if (username.equals("")) {
			error = "Please enter a username";
			password = "";
			return "loginpage";
		}
		if (password.equals("")) {
			error = "Please enter a password";
			username = "";
			return "loginpage";
		}
		if (bool == true) {
			return "index";
		} else {
			username = "";
			password = "";
			return "loginpage";
		}
	}
}
