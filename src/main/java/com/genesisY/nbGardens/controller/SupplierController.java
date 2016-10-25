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
	private DataModel<Supplier> datamodel; 
	
	public String viewSuppliers(){
		System.out.println(">>>>>>>>>");
		datamodel = new ListDataModel<Supplier>(supplierService.viewSuppliers());
		return "viewsupplier"; 	
	}
}