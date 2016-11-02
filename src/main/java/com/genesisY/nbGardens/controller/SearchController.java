package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.services.SearchService;

@Named("search")
@RequestScoped
public class SearchController {

	@Inject
	private SearchService searchService;
	
	@Inject
	private ProductsController prodController;

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
	
		if (term != null)
		{	

			prodController.setDataModel(new ListDataModel<Product>(searchService.prodSearch(term)));
			return "subcategory";
			
		}else{
			return "category";
			
		}
		
	}

}
