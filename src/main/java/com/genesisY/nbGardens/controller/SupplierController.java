package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.SupplierService;

import javax.faces.model.ListDataModel;



@Named ("suppliers")
@SessionScoped
public class SupplierController implements Serializable {

	@Inject 
	private SupplierService supplierService; 
	private DataModel<Supplier> datamodel; 
	
	public String viewSuppliers(){
		System.out.println(">>>>>>>>>");
		setDatamodel(new ListDataModel<Supplier>(supplierService.viewSuppliers()));
		return "viewsupplier"; 
		
	}

	public DataModel<Supplier> getDatamodel() {
		return datamodel;
	}

	public void setDatamodel(DataModel<Supplier> datamodel) {
		this.datamodel = datamodel;
	}
	
	
	
	
}
