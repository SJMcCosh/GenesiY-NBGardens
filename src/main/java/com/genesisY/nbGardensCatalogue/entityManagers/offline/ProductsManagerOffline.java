package com.genesisY.nbGardensCatalogue.entityManagers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.hibernate.engine.transaction.internal.NullSynchronizationException;
import org.hibernate.query.criteria.internal.predicate.NullnessPredicate;

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
	public Product getProductByName(String name) {
		try {
			for (Product p : initialData.getProductList()) {
				try {
					System.out.println(p.getName().toLowerCase().contains(name.toLowerCase()));
					if (p.getName().toLowerCase().contains(name.toLowerCase())) {
						System.out.println(">>>>>>>>>>>>>>>>> ProductName = " + p.getName());
						return p;
					}
				} catch (NullPointerException npe) {
					return null;
				}
			}
		} catch (NullPointerException npe) {
			return null;
		}
		return null;
	}

}
