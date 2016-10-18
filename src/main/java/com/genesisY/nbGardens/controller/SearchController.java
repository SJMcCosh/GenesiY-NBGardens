package com.genesisY.nbGardens.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.entityManagers.offline.ProductsManagerOffline;


@SuppressWarnings("serial")
@Named("search")
@SessionScoped
public class SearchController implements Serializable{

	@Inject
	private ProductManager pm;
	
	
	private Product product;
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String search() {
		return "index";
	}
	
	public Product searchProduct(String term){
		
		
		for (Product p : pm.getProducts()){
			ArrayList<Tag> tags = (ArrayList<Tag>) p.getTags();
			for(Tag t : tags){
				if (term.equals(t)){
					return p;
				}
			}
		}
		return null;
	}
	
	
}
