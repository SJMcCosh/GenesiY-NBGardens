package com.genesisY.nbGardensCatalogue.entities;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Basic outline for Address class
 * Contains getters and setter for variables
 * @author Samuel McCosh
 */
@Entity
@Table (name = "address")
public class Address {
	
	@Id
	@Column (name = "aid")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int addressID;
	
	@Column (name = "houseNmNo", nullable = false, length = 120)
	@Size (min = 1, max = 120)
	private String houseNmNo;
	
	@Column (name = "street", nullable = false, length = 70)
	@Size (min = 5, max = 70)
	private String street;
	
	@Column (name = "townCity", nullable = false, length = 58)
	@Size (min = 2, max = 58)
	private String townCity;
	
	@Column (name = "county", nullable = false, length = 35)
	@Size (min = 4, max = 35)
	private String county;
	
	@Column (name = "postcode", nullable = false, length = 9)
	@Size (min = 7, max = 9)
	private String postcode;
	
	@OneToMany
	@JoinColumn (name = "customer_fk", nullable = false)
	@NotNull
	private Customer customer;
	
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getHouseNmNo() {
		return houseNmNo;
	}
	public void setHouseNmNo(String houseNmNo) {
		this.houseNmNo = houseNmNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
