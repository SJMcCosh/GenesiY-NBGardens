package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.ProductsBean;
import com.genesisY.nbGardensCatalogue.entities.Product;

@Named("products")
@SessionScoped


public class Products implements Serializable{

	@Inject
	ProductsBean pb;
	private Product product;
	private DataModel<Product> productData = null;
	
	@SuppressWarnings("unchecked")
	public String view(){	
		productData = (DataModel<Product>) pb.getProducts();
		return "productpage";
	}
	
	public String view(long id){	
		product = pb.getProduct(id);	
		return "productpage";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
