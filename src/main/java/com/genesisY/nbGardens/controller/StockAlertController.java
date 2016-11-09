package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.StockAlert;
import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.StockAlertService;

@SuppressWarnings("serial")
@Named("stockAlerts")
@SessionScoped
public class StockAlertController implements Serializable {
	
	@Inject
	private StockAlertService saService;
	
	@Inject
	private ProductService prodService;
	
	private DataModel<StockAlert> dataModel;
	private DataModel<Product> productDataModel;
	
	public String onLoad()
	{
		dataModel = new ListDataModel<StockAlert>(saService.getAllStockAlerts());
		System.out.println(">>>>> Controller");
		return "stockalerts";
	}

	public DataModel<StockAlert> getDataModel() {
		return dataModel;
	}
	
	public String loadSelectedProduct(int id) {
		productDataModel = new ListDataModel<Product>(prodService.getProductById(id));
		return "productDataModel";
	}
	
	public DataModel<Product> getProductDataModel() {
		return productDataModel;
	}

	public void setDataModel(DataModel<StockAlert> dataModel) {
		this.dataModel = dataModel;
	}
}
