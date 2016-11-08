package com.genesisY.nbGardensCatalogue.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BasketItem {		
	//quantity.
	private int quantity;	
	//item cost.	
	private Double itemSubtotal;
	//Product.
	private Product product;

	
	public BasketItem(Product _product, int _quantity)
	{	
		this.product = _product;
		this.quantity = _quantity;		
	}
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Double getItemSubtotal() {
		
		return quantity * product.getPrice();
	}


//	public void setItemCost(Double itemCost) {
//		this.itemCost = itemCost;
//	}

	
	public Product getProduct() {
		return product;
	}

		
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	
	
	

}
