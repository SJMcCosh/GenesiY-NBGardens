package com.genesisY.nbGardens.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Basic outline for Address class Contains getters and setter for variables
 * 
 * @author Samuel McCosh
 */
@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressID;

	@Column(name = "addressLine1", nullable = false, length = 120)
	@Size(min = 1, max = 120)
	@NotNull
	private String addressLine1;

	@Column(name = "addressLine2", nullable = false, length = 70)
	@Size(min = 5, max = 70)
	private String addressLine2;
	
	@Column(name = "addressLine3", nullable = false, length = 70)
	@Size(min = 5, max = 70)
	private String addressLine3;

	@Column(name = "townCity", nullable = false, length = 58)
	@Size(min = 2, max = 58)
	@NotNull
	private String townCity;

	@Column(name = "county", nullable = false, length = 35)
	@Size(min = 4, max = 35)
	private String county;
	
	@Column(name = "country")
	private String country;

	@Column(name = "postcode", nullable = false, length = 9)
	@Size(min = 7, max = 9)
	@NotNull
	private String postcode;

	@OneToMany
	@JoinColumn(name = "customer_fk", nullable = false)
	private Customer customer;

	public Address() {

	}

	public Address(String addressLine1, String addressLine2, String addressLine3, String townCity, String country, String postcode) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.townCity = townCity;
		this.county = country;
		this.postcode = postcode;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getAddressLine3() {
		return addressLine2;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getTownCity() {
		return townCity;
	}

	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Add code to pull from database
	 */

}
