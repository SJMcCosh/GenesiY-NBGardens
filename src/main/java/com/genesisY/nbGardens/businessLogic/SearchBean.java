package com.genesisY.nbGardens.businessLogic;

import java.util.ArrayList;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.entityManagers.offline.ProductsManager;

public class SearchBean {

	
	public Product searchProduct(String term){
		ProductManager pm = new ProductsManager();
		
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
