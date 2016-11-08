package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.StockAlert;
import com.genesisY.nbGardens.services.StockAlertService;

@SuppressWarnings("serial")
@Named("stockAlerts")
@SessionScoped
public class StockAlertController implements Serializable {
	
	@Inject
	private StockAlertService saService;
	
	private DataModel<StockAlert> dataModel;
	
	public String onLoad()
	{
		dataModel = new ListDataModel<StockAlert>(saService.getAllStockAlerts());
		System.out.println(">>>>> Controller");
		return "stockalerts";
	}

	public DataModel<StockAlert> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<StockAlert> dataModel) {
		this.dataModel = dataModel;
	}

}
