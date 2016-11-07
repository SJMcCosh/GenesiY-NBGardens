package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.SearchService;
import com.genesisY.nbGardensCatalogue.entities.Product;

@SuppressWarnings("serial")
@Named("search")
@SessionScoped
public class SearchController implements Serializable {

	@Inject
	private SearchService searchService;
	
	@Inject
	private ProductsController prodController;
	
	@Inject
	private ErrorController errorController;

	private String term = "";

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * Takes the term that the customer searches with and sends it to the service layer to be checked
	 * @return String : the subcategory page or the index page depending if the term has a value
	 */
	public String search() {

		if (term.equals("")) {
			
			errorController.setErrorMessage("That search term is invalid, please enter another term.");
			
			return "error";
		} else {
			
			if (searchService.getSearchedProducts(term) != null) {
				prodController.setDataModel(new ListDataModel<Product>(searchService.getSearchedProducts(term)));
				
				return "searchresult";
			} else {
				return "index";
			}
		}
	}
}
