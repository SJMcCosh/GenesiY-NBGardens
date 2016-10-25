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
