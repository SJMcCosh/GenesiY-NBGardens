package com.genesisY.nbGardens.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.BasketService;
import com.genesisY.nbGardensCatalogue.entities.Basket;
import com.genesisY.nbGardensCatalogue.entities.BasketItem;

@Named("basket")
public class BasketController implements Serializable{

	
	//private Basket basket;
	private DataModel<BasketItem> dataModel = null;
	@Inject
	private BasketService basketService;
	
	
//	@SuppressWarnings("unchecked")
//	public String allProducts()
//	{
//		
//		dataModel = new ListDataModel(basketService.getBasketItems());
//		System.out.println("At controller");
//		System.out.println("Datamodel Row count: " + dataModel.getRowCount());
//		//System.out.println("Datamodel Row count: " + dataModel.);
//		return "basket";
//	}
	
	public DataModel<BasketItem> getDataModel() {
		
		dataModel = new ListDataModel(basketService.getBasketItems());
		System.out.println("At controller");
		System.out.println("Datamodel Row count: " + dataModel.getRowCount());
		
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
		
		System.out.println("SELECTED QUANTITY>>>>>>>>>>>>>>>>: " + selectedQuantity);
	}
	
	/*public void removeBasketItem(String itemName) 
	{
		ArrayList<BasketItem>basketItems = (ArrayList<BasketItem>) basketService.getBasketItems();
		System.out.println(">>>>>>>>>>>>>> Item clicked: " + itemName);
		
//		for(int i = 0; i<basketService.getBasketItems().size(); i++)
		for(int i = 0; i<basketItems.size(); i++)
		{
			//check for each item name = name passed.
			if(basketItems.get(i).getProduct().getName().equals(itemName))
			{
				System.out.println(">>>>>>>> Found name: " + basketService.getBasketItems().get(i).getProduct().getName());
				basketService.getBasketItems().remove(i);
				break;
			}
		}		
	}*/
	
	/**
	 * Created: 27/10/2026
	 * By: Callum Holden
	 * This method will delete the item from the list by name.
	 * @param itemName
	 */
	public String removeBasketItem(String itemName) 
	{
		ArrayList<BasketItem>basketItems = (ArrayList<BasketItem>) basketService.getBasketItems();
		System.out.println(">>>>>>>>>>>>>> Item clicked: " + itemName);
		for(int i = 0; i<basketItems.size(); i++)
		{
			//check for each item name = name passed.
			if(basketItems.get(i).getProduct().getName().equals(itemName))
			{
				//For debugging.
					System.out.println(">>>>>>>> Found name: " + basketService.getBasketItems().get(i).getProduct().getName());
				//Remove the current item from the array list.
				basketService.getBasketItems().remove(i);
				break;
			}
		}
		
		
		
		
		return "basket";
		
	}
	
	
//	public Basket getProduct() {
//		return basket;
//	}
//
//	public void setProduct(Basket basket) {
//		this.basket = basket;
//	}
	
	
}
