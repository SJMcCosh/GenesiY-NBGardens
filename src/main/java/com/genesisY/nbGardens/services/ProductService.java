package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;

@RequestScoped
public class ProductService {

	@Inject
	private ProductManager productInt;

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(String category) {
		try {
			if (category != null) {
				return productInt.getProducts();
			}else{
				return null;
			}
		} catch (NullPointerException npe) {

		}
		return null;

	}

}
