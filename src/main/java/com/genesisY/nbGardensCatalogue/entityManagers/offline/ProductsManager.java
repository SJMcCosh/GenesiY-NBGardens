package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManagerInterface;
import com.genesisY.nbGardensCatalogue.initialData.InitialData;

@Stateless
@Default
public class ProductsManager implements ProductManagerInterface {

	@Inject
	private InitialData initialData;

	@Override
	public List<Product> getProducts() {
		return initialData.getProductList();
	}

	@Override
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

	@Override
	public List<Product> getProduct() {
		return initialData.getProductList();
	}

}
