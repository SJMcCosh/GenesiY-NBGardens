package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;

@Stateless

public class SearchService {

	@Inject
	private ProductManager productManager;

	/**
	 * Checks the term and validates the term and only allows characters a-z and A-Z
	 * @param term : String the term that has been passed in from the frontend
	 * @return List<Product> : a list of products that match the term
	 */
	@SuppressWarnings("null")
	public List<Product> getSearchedProducts(String term) {
		if (term != null) {
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
