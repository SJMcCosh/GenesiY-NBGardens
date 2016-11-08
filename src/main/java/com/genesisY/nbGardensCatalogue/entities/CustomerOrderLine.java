package com.genesisY.nbGardensCatalogue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * Customer Order Line outline
 * @author Brian McLaughlin
 */
@Entity
@Table(name = "customerorderline")
public class CustomerOrderLine {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "customerorderid_fk", nullable = false)
	@NotNull
	private int fk_CustomerOrderID;

	@ManyToOne
	@JoinColumn(name = "productid_fk", nullable = false)
	@NotNull
	private int fk_ProductID;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity;

	@Column(name = "price", nullable = false)
	@NotNull
	private double price;

	public CustomerOrderLine() {

	}

	public CustomerOrderLine(int fk_CustomerOrderID, int fk_ProductID, int quantity, double price) {
		this.fk_CustomerOrderID = fk_CustomerOrderID;
		this.fk_ProductID = fk_ProductID;
		this.quantity = quantity;
		this.price = price;
	}

	public int getFk_CustomerOrderID() {
		return fk_CustomerOrderID;
	}

	public void setFk_CustomerOrderID(int fk_CustomerOrderID) {
		this.fk_CustomerOrderID = fk_CustomerOrderID;
	}

	public int getFk_ProductID() {
		return fk_ProductID;
	}

	public void setFk_ProductID(int fk_ProductID) {
		this.fk_ProductID = fk_ProductID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
