package com.genesisY.nbGardens.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Purchase Order Outline
 * 
 * @author Thomas Chatterjee
 *
 */
@Entity
@Table(name = "PurchaseOrder")
public class PurchaseOrder {
	@Id
	@Column(name = "purchaseID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseID;
	@Column(name = "totalPrice", nullable = false)
	@NotNull
	private double totalPrice;
	@OneToOne
	@JoinColumn(name = "supplierID_fk", nullable = false)
	@NotNull
	private Supplier supplier;
	@OneToOne
	@JoinColumn(name = "login_fk", nullable = false)
	@NotNull
	private EmployeeLogin employee;

	/**
	 * @param purchaseID
	 * @param totalPrice
	 * @param supplier
	 * @param employee
	 */
	public PurchaseOrder(double totalPrice, Supplier supplier, EmployeeLogin employee) {
		this.totalPrice = totalPrice;
		this.supplier = supplier;
		this.employee = employee;
	}

	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public EmployeeLogin getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeLogin employee) {
		this.employee = employee;
	}
}
