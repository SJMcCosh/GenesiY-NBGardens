package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;

@Stateless

public class ProductService {

	@Inject
	private ProductManager productManager;

	private boolean categoryValidate(String category) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z -']+$");
		Matcher matcher = pattern.matcher(category);
		if (category.length() > 7 && category.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}

	private boolean nameValidate(String name) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z ()!',.-]+$");
		Matcher matcher = pattern.matcher(name);
		if (name.length() > 7 && name.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}

	/**
	 * Gets the products that a customer wants based on the category they chose
	 * 
	 * @param category
	 *            that the customer wants
	 * @return List<Product> : the list of products that have been returned from
	 *         the data store
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(String category) {
		try {
			if (category != null && categoryValidate(category)) {
				return productManager.getProducts();
			} else {
				return null;
			}
		} catch (NullPointerException npe) {
			return null;
		}

	}

	/**
	 * Gets a product based on the name that has been sent in
	 * 
	 * @param name
	 *            : String of the product
	 * @return Product : the product that has been returned
	 */
	public Product getProductByName(String name) {
		if (nameValidate(name)) {
			return productManager.getProductByName(name);
		}
		return null;
	}

}
