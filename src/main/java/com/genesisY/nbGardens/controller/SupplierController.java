package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.model.ListDataModel;

import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.SupplierService;

@Named ("suppliers")
@SessionScoped
public class SupplierController implements Serializable {

	@Inject 
	private SupplierService supplierService; 
	private DataModel<Supplier> datamodel; 
	
	public String viewSuppliers(){
		datamodel = new ListDataModel<Supplier>(supplierService.viewSuppliers());
		return "viewsupplier"; 
		
	}
	
	
	
	
}
