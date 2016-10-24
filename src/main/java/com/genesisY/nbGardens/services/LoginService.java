package com.genesisY.nbGardens.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entityManagers.AccountManager;

@Stateless

public class LoginService {

	@Inject
	private AccountManager accountManager;

	private Employee getEmployeeByUsername(String username) {
		try {
			if (username != null) {
				return accountManager.findByUsername(username);
			}
		} catch (NullPointerException npe) {

		}

		return null;
	}

	private String hash(String pass) {
		byte[] digested = null;
		String passhash;
		try {
			byte[] hash = pass.getBytes("UTF-8");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(hash);
			digested = digest.digest();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		passhash = bytestohex(digested);
		return passhash;
	}

	private String bytestohex(byte[] digested) {
		final StringBuilder hexhash = new StringBuilder();
		for (byte b : digested) {
			hexhash.append(String.format("%02x", b));
		}
		return hexhash.toString();
	}

	public boolean passCheck(String username, String password) {
		Employee gnome = getEmployeeByUsername(username);
		System.out.println(">>>> " + username +", "+ password + " <<<<");
		if (gnome != null) {
			String pass = hash(password);
			if (password.equals(gnome.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
