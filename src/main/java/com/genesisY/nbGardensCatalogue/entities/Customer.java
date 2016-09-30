package com.genesisY.nbGardensCatalogue.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * customer class, setting/getting customer passwords and usernames
 * 
 * @author Karrus
 *
 */

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "username", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String username;

	@Column(name = "password", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String password;

	public Customer() {

	}

	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
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

}
