package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.businessLogic.SearchBean;
import com.genesisY.nbGardensCatalogue.entities.Product;


@Named("search")
@SessionScoped
public class SearchController implements Serializable{

	@Inject
	private SearchBean sb;
	private Product product;
	 
	public String search(String term){
		//TODO: get the serch result into the service layer bean
		product = sb.searchProduct(term);
		return "subcategory";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
