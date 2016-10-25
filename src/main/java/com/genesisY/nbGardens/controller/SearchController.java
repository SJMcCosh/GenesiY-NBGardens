package com.genesisY.nbGardens.controller;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Tag;
import com.genesisY.nbGardens.entityManagers.ProductManager;

@Named("search")
@SessionScoped
public class SearchController {

	private ProductManager pm;

	private Product product;
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String search() {
		return "index";
	}

	public Product searchProduct(String term) {

		for (Product p : pm.getProducts()) {
			ArrayList<Tag> tags = (ArrayList<Tag>) p.getTags();
			for (Tag t : tags) {
				if (term.equals(t)) {
					return p;
				}
			}
		}
		return null;
	}

}
