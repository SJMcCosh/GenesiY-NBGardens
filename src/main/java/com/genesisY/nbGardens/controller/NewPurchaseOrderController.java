package com.genesisY.nbGardens.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.EmployeeLogin;
import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.PurchaseOrderService;
import com.genesisY.nbGardens.services.SupplierService;

@Named("newPurchase")
@SuppressWarnings("serial")
@SessionScoped
public class NewPurchaseOrderController implements Serializable {

	@Inject
	private PurchaseOrderService purchaseOrderService;
	private DataModel<Product> dataModel = null;
	private Supplier supplier; 
	private int quantity; 
	private DataModel<Product> prodList; 
	private double totalPrice; 
	private EmployeeLogin employee; 
	private Product product; 
	
	

	public DataModel<Product> getDataModel() {
		return dataModel;
	}




	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}




	public Supplier getSupplier() {
		return supplier;
	}




	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public int getQuantity() {
		return quantity;
	}

	public void addToProdList(){
		int q = this.quantity;
		for(int i=0; i<q; i++){
		
		//this.prodList.add(product);
		}
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void createNewPurchaseOrder()
	{
	
		purchaseOrderService.createPurchaseOrder(totalPrice, supplier, prodList);
	}
	
}