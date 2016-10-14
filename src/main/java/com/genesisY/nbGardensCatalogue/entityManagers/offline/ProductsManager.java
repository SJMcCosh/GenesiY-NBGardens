package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Singleton
public class ProductsManager implements ProductManager {

	@Inject
	private InitialData initialData;

	public List<Product> getProducts() {
		return initialData.getProductList();
	}

	public Product getProduct(long id) {

		for (Product p : initialData.getProductList()) {
			try {
				if (p.getId() == id) {
					return p;
				}
			} catch (ArrayIndexOutOfBoundsException aiobe) {

			}
		}

		return null;
	}

	public List<Product> getProduct() {
		return initialData.getProductList();
	}

}
