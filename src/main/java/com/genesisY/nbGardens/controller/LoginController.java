package com.genesisY.nbGardens.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.LoginService;

@Named("employee_login")
@RequestScoped
public class LoginController {

	@Inject
	private LoginService passcheck;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private EmployeeController employeeController;
	private String username = "";
	private String password = "";
	private String error = "";
	private boolean errorbool = false;

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
		if (username.equals("")) {
			error = "Please enter a username";
			password = "";
			return "loginpage";
		} else if (password.equals("")) {
			error = "Please enter a password";
			password = "";
			return "loginpage";
		} else if (passcheck.passCheck(username, password) == true) {
			userCredentials.setUsername(username);
			userCredentials.setLoggedin(passcheck.passCheck(username, password));
			return "newproduct";
		} else {
			error = "Invalid username and password";
			username = "";
			password = "";
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

	public boolean isErrorbool() {
		return errorbool;
	}

	public void setErrorbool(boolean errorbool) {
		this.errorbool = errorbool;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
