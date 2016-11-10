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
	private Product selectedProduct;

	public String onLoad(Product p)
	{
		dataModel = new ListDataModel<StockAlert>(saService.getAllStockAlerts());
		setSelectedProduct(p);
		System.out.println(selectedProduct.getName());
		return "stockalerts";
	}
	public String onLoad()
	{
		dataModel = new ListDataModel<StockAlert>(saService.getAllStockAlerts());
		return "stockalerts";
	}

	public DataModel<StockAlert> getDataModel() {
		return dataModel;
	}

	public void setSelectedProduct(Product p) {
		System.out.println(p.getName());
		this.selectedProduct = p;
	}

	public Product getSelectedProduct() {
		return this.selectedProduct;
	}

	public void setDataModel(DataModel<StockAlert> dataModel) {
		this.dataModel = dataModel;
	}

}