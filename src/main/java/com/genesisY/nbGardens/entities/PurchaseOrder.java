package com.genesisY.nbGardens.entities;

import java.util.List;

import javax.faces.model.DataModel;
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
	@OneToMany
	@JoinColumn(name = "productID_fk",  nullable = false)
	@NotNull 
	private Product product;
	private DataModel<Product> prodList; 

	/**
	 * @param purchaseID
	 * @param totalPrice
	 * @param supplier
	 * @param prodList 
	 * @param employee 
	 * @param employee
	 */
	public PurchaseOrder(double totalPrice, Supplier supplier, DataModel<Product> prodList) {
		this.totalPrice = totalPrice;
		this.supplier = supplier;
		this.prodList = prodList;
	}
	public DataModel<Product> getProdList() {
		return prodList;
	}

	public void setProdList(List<Product> prodList) {
		this.prodList = (DataModel<Product>) prodList;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}