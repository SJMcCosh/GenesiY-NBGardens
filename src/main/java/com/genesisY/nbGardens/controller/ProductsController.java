package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;


import com.genesisY.nbGardensCatalogue.entities.Product;

@Named("products")
@SessionScoped

public class ProductsController implements Serializable{

	private Product product;
	private String price;
	private String name;
	private DataModel<Product> dataModel = null;
	
	
	
	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public String view(){	

		return "productpage";
	}
	
	public String view(long id){	
	
		return "productpage";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}