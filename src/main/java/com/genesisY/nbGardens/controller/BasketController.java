package com.genesisY.nbGardens.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.BasketService;
import com.genesisY.nbGardensCatalogue.entities.BasketItem;

@SuppressWarnings("serial")
@Named("basket")
@SessionScoped
public class BasketController implements Serializable{

	
	private DataModel<BasketItem> dataModel = null;
	@Inject
	private BasketService basketService;
	
	
	public DataModel<BasketItem> getDataModel() {
		
		dataModel = new ListDataModel<BasketItem>(basketService.getBasketItems());
	
		return dataModel;
	}

	public void setDataModel(DataModel<BasketItem> dataModel) {
		this.dataModel = dataModel;
	}
	
	public Double getBasketSubTotal()
	{
		Double runningTotal = 0.0;	
		
		for(int i = 0; i < basketService.getBasketItems().size();i++)
		{			
			runningTotal+=basketService.getBasketItems().get(i).getItemSubtotal();
		}
		
		return runningTotal;
	}
	
	/**
	 * Created: 25/10/2016
	 * By: Callum Holden
	 * Updated By: Aiesha Jules 
	 * 
	 * 
	 * This method will get the total count of the items in the cart.
	 * @return
	 */
	public int getBasketSize()
	{
		int itemsCount = 0;
		
		for(BasketItem b : basketService.getBasketItems())
		{
			itemsCount+=b.getQuantity();
		}
		return itemsCount;
	}
		
	
	/**
	 * Created: 24/10/2016
	 * By: Callum Holden
	 * Updated By: Aiesha Jules
	 * 
	 * 
	 * This method will listen for a change in the quantity dropdowns on the basket page.
	 * @param e
	 */
	public void itemQuantityChanged(ValueChangeEvent e)
	{
		String selectedQuantity = e.getNewValue().toString();
		
	}
	
	/**
	 * Created: 27/10/2026
	 * By: Callum Holden
	 * This method will delete the item from the list by name.
	 * @param itemName
	 */
	public String removeBasketItem(String itemName) 
	{
		ArrayList<BasketItem>basketItems = (ArrayList<BasketItem>) basketService.getBasketItems();
		for(int i = 0; i<basketItems.size(); i++)
		{
			//check for each item name = name passed.
			if(basketItems.get(i).getProduct().getName().equals(itemName))
			{

				//Remove the current item from the array list.
				basketService.getBasketItems().remove(i);
				break;
			}
		}
		
		return "basket";
		
	}
	
	public void setModelToNull(){
		dataModel = null;
	}
	
	
//	public Basket getProduct() {
//		return basket;
//	}
//
//	public void setProduct(Basket basket) {
//		this.basket = basket;
//	}
	
	
}
