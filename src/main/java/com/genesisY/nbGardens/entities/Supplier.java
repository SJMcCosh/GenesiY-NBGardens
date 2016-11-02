package com.genesisY.nbGardens.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Basic outline for Supplier class Contains getters and setter for variables
 * 
 * @author Samuel McCosh
 */

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierID;

	@Column(name = "supplierName", nullable = false, length = 200)
	@Size(min = 1, max = 200)
	private String supplierName;

	@Column(name = "telNo", nullable = false, length = 11)
	@Size(min = 7, max = 11)
	private String telephoneNumber;

	@Column(name = "emailAddr", nullable = false, length = 200)
	@Size(min = 7, max = 200)
	private String emailAddress;
	
	@ManyToMany
	@NotNull
	private List<Product> products;
	
	@Column(name = "address")
	@OneToOne
	@NotNull
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param supplierName
	 * @param telephoneNumber
	 * @param emailAddress
	 */
	public Supplier(String supplierName, String telephoneNumber, String emailAddress, Address address, List<Product> products) {
		this.supplierName = supplierName;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.products = products;
	}

	public int getSupplierID() {
		return supplierID;

	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String name) {
		this.supplierName = name;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Add code to pull from database
	 */

}
