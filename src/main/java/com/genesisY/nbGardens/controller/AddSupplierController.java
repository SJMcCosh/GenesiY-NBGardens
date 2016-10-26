package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.SupplierService;

@SuppressWarnings("serial")
@Named("supplierAdd")
@SessionScoped
public class AddSupplierController implements Serializable {

	@Inject
	private SupplierService supplierService;
	private Supplier supplier;
	private DataModel<Supplier> dataModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String name; 
	private String phone; 
	private String email; 
	private Address address; 
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	
	}
	
	public void setAddress(Address address){
		
		this.address = address; 
	}
	
	
	
	
}