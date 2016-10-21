package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
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
					System.out.println(">>>>>>>>>>>>>>>>>> " + p.getName());
					System.out.println(">>>>>>>>>>>>>>>>>> " + term);
					if(p.getName().equals(term)){
						System.out.println(">>>>>>>>>>>>>>>>>> check is valid");
						tempList.add(p);
					}
				}
				return tempList;
			} catch(NullPointerException npe){
				System.out.println(">>>>>>>>>>>>>>>>>> Dumbass");
			}

		} else {

			return null;
		}
		return null;

	}

}
