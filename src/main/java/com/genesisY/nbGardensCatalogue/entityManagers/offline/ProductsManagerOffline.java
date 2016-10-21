package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class ProductsManagerOffline implements ProductManager {

	@Inject
	private InitialData initialData;

	@Override
	public List<Product> getProducts() {
		return initialData.getProductList();
	}

	@Override
	public Product getProduct(String id) {
		try {
			for (Product p : initialData.getProductList()) {
				try {
					if (p.getName() == id) {
						System.out.println(">>>>>>>>>>>>>>>>> ProductName = " + p.getName());
						return p;
					}
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					return null;
				}
			}
		} catch (NullPointerException npe) {
			return null;
		}
		return null;
	}

}
