package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.ProductManager;
import com.genesisY.nbGardensCatalogue.entityManagers.TagManager;

@Stateless

public class TagService {

	@Inject
	private TagManager tmo;
	@Inject
	private ProductManager pm;
	@Inject
	private SearchService searchService;

	@SuppressWarnings("null")
	public List<Tag> getAllTags(String category) {
		List<Tag> tList = new ArrayList<Tag>();
		try {
			for (Product p : pm.getProductsByCategory(category)) {
				for (Tag t : p.getTagList()) {
					if (!tList.contains(t)) {
						tList.add(t);
					}
				}
			}
			return tList;
		} catch (NullPointerException npe) {
			return null;
		}
	}
	
	@SuppressWarnings("null")
	public List<Tag> getSearchTags(String term) {
		List<Tag> tList = new ArrayList<Tag>();
		try {
			for (Product p : searchService.getSearchedProducts(term)) {
				for (Tag t : p.getTagList()) {
					if (!tList.contains(t)) {
						tList.add(t);
					}
				}
			}
			return tList;
		} catch (NullPointerException npe) {
			return null;
		}
	}
}
