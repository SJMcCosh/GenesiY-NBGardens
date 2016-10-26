package com.genesisY.nbGardensCatalogue.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Basket {
	
	
	//The list of items in the basket.
	private List<BasketItem> basketItems;
	
	//The count of items in the basket.
	private int itemsCount;	
	
	//item cost	
	private Double basketTotal;

	public void addBasketItem(BasketItem basketItem)
	{
		this.basketItems.add(basketItem);
		this.itemsCount++;
	}
	
	//Need a remove basket item method.
	
	
	
	public List<BasketItem> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	public int getItemsCount() {
		
		for(BasketItem b : basketItems)
		{
			itemsCount += b.getQuantity();
		}
		
		return itemsCount;
	}
	
	public Double getBasketTotal() {
		return basketTotal;
	}

	public void setBasketTotal(Double basketTotal) {
		this.basketTotal = basketTotal;
	}

	
//	public Basket(int _itemsCount, Double _basketTotal)
//	{
//			
//		this.itemCost = _itemsCost;
//		this.
//	}
	
	
	

}

