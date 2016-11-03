package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;

@Stateless

public class SearchService {

	@Inject
	private ProductManager productManager;
	
	private boolean searchValidate(String search) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(search);
		if (search.length() > 7 && search.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}

	/**
	 * Checks the term and validates the term and only allows characters a-z and A-Z
	 * @param term : String the term that has been passed in from the frontend
	 * @return List<Product> : a list of products that match the term
	 */
	@SuppressWarnings("null")
	public List<Product> getSearchedProducts(String term) {
		if (term != null && searchValidate(term)) {
			try{
				ArrayList<Product> tempList = new ArrayList<Product>();
				for(Product p : productManager.getProducts()){
					if(p.getName().toLowerCase().contains(term.toLowerCase())){
						tempList.add(p);
					}
				}
				return tempList;
			} catch(NullPointerException npe){
				return null;
			}

		} else {

			return null;
		}

	}

}
