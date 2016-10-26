package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.SupplierService;

@Named ("suppliers")
@RequestScoped
public class SupplierController {

	@Inject
	private SupplierService supplierService; 
	private DataModel<Supplier> dataModel; 
	
	public DataModel<Supplier> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}

	public String viewSuppliers(){
		dataModel = new ListDataModel<Supplier>(supplierService.viewSuppliers());

		return "viewsupplier"; 	
	}
}