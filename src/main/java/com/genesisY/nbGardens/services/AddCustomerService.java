package com.genesisY.nbGardens.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entityManagers.AccountManager;
import com.genesisY.nbGardensCatalogue.entityManagers.AddressManager;

@Stateless
public class AddCustomerService {

	@Inject
	private AccountManager accountManager;
	@Inject
	private AddressManager addressManager;

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

	public void addCustomer(String firstname, String surname, String phoneNumber, String email, String username,
			String password, String addressLine1, String addressLine2, String addressLine3, String townCity,
			String county, String postcode) {

		String pass = hash(password);
		for (int x = 0; x < 1000; x++) {
			pass = hash(pass);
		}
		Customer c = new Customer(firstname, surname, email, username, pass, phoneNumber);
		accountManager.addCustomer(c);
		Address a = new Address(addressLine1, addressLine2, addressLine3, townCity, county, postcode, true, c);
		addressManager.addAddress(a);

	}

}
