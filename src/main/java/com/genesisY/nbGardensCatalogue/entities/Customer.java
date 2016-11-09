package com.genesisY.nbGardensCatalogue.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@Column(name = "email", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String email;
	
	@Column(name = "firstName", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String firstName;
	
	@Column(name = "surname", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String surname;
	
	@Column(name = "phoneNumber", nullable = false)
	@Size(min = 5, max = 225)
	@NotNull
	private String phoneNumber;
	
	private List<CustomerOrder> customerOrders;

	public Customer() {

	}

	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Customer(String firstName, String surname, String email, String username, String password, String phoneNumber){
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer(String firstName, String surname, String email, String username, String password, String phoneNumber, List<CustomerOrder> customerOrders){
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.customerOrders = customerOrders;
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
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
}
