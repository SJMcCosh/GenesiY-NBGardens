package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.LoginService;

@SuppressWarnings("serial")
@Named("login")
@SessionScoped
public class LoginController implements Serializable {

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
		if (passcheck.passCheck(username, password)) {
			return "index";
		} else {
			return "loginpage";
		}
	}
}
