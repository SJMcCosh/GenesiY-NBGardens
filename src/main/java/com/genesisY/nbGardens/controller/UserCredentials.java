package com.genesisY.nbGardens.controller;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserCredentials {
	
	private String username;
	private boolean loggedin;
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	public boolean isLoggedin() {
		return loggedin;
	}
	protected void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
}
