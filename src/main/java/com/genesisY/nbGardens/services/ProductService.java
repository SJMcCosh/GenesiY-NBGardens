package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.ProductManager;
import com.genesisY.nbGardens.entityManagers.offline.ProductManagerOffline;

@RequestScoped
public class ProductService {

	@Inject
	private ProductManager productInt;
	@Inject
	private ProductManager productsManager;
	@Inject
	private SupplierService supplierService;

	public List<Product> getAllProducts() {
		try {
			return productInt.getProducts();
		} catch (NullPointerException npr) {
			return null;
		}

	}

	public List<Product> viewProducts() {
		List<Product> products = productsManager.getAllProducts();

		return products;

	}

	public Product getProductByName(String name) {
		try {
			for (Product a : productInt.getProducts()) {
				if (name.equals(a.getName())) {
					return a;
				}
			}
		} catch (NullPointerException npr) {
			return null;
		}
		return null;
	}

	public List<Product> getProductById(int id) {
		if (productsManager.getProductById(id) != null) {
			return productsManager.getProductById(id);
		} else {
			return null;
		}
	}

	public void updateProduct(Product product) {
		if (product != null) {
			System.out.println("<<<<<<<<<<<<<<<<" + product.getPrice());
			productInt.updateProduct(product);
		}
	}

	public void addProduct(Product product) {
		if (product != null) {
			productInt.addProduct(product);
		}

	}

	public List<Supplier> getSuppliers(Product product) {
		List<Supplier> suppliers = supplierService.viewSuppliers();
		List<Supplier> finalSupplier = new ArrayList<Supplier>();
		for (Supplier s : suppliers) {
			if (s.getProducts().contains(product)) {
				finalSupplier.add(s);
			}
		}
		return finalSupplier;
	}

	public Product viewProduct(Product p) {
		List<Product> selectedProduct = productsManager.getAllProducts();
		List<Product> foundProduct = null;

		for (Product p1 : selectedProduct) {
			if (p1.getName().equals(p.getName())) {

				return p;
			}
		}
		return null;
	}

}
