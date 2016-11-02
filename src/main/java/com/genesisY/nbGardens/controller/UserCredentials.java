package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SuppressWarnings("serial")
@SessionScoped
public class UserCredentials implements Serializable {

	private String username = "";

	private boolean loggedin = false;
	private int attempts = 0;
	
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
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
}
