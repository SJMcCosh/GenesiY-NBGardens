package com.genesisY.nbGardens.controller;

import java.io.Serializable;

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
	
	public int getBasketSize()
	{
		return basketService.getBasketItems().size();
	}
		
	
	public void itemQuantityChanged(ValueChangeEvent e)
	{
		String selectedQuantity = e.getNewValue().toString();
		
		System.out.println("SELECTED QUANTITY>>>>>>>>>>>>>>>>: " + selectedQuantity);
	}
	
	
//	public Basket getProduct() {
//		return basket;
//	}
//
//	public void setProduct(Basket basket) {
//		this.basket = basket;
//	}
	
	
}
