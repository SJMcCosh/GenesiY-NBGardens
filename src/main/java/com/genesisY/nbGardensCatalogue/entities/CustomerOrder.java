package com.genesisY.nbGardensCatalogue.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This is the outline for the Customer Order class
 * @Aiesha 
 */

@Entity
@Table (name = "customer_order")
public class CustomerOrder {
	
	@Id
	@Column (name = "customerOrderId")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int customerOrderID;
	
	@OneToMany
	@Column (name = "customerid_fk", nullable = false)
	@NotNull
	private int fk_customerID;
	
	@Column (name = "total_price", nullable = false)
	@NotNull
	private double totalPrice;
	
	public int getCustomerOrderID() {
		return customerOrderID;
	}
	public void setCustomerOrderID(int customerOrderID) {
		this.customerOrderID = customerOrderID;
	}
	public int getFk_customerID() {
		return fk_customerID;
	}
	public void setFk_customerID(int fk_customerID) {
		this.fk_customerID = fk_customerID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	

}
