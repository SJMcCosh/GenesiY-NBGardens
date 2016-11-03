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

	@SuppressWarnings("null")
	public List<Tag> getAllTags() {
		List<Tag> tList = new ArrayList<Tag>();
		try {
			for (Product p : pm.getProducts()) {
				for (Tag t : p.getTagList()) {
					if (!tList.contains(t)) {
						tList.add(t);
					}
				}
			}
			System.out.println(">>>>>>>>>>>>>> Got tags");
			return tList;
		} catch (NullPointerException npe) {
			System.out.println(">>>>>>>>>>>>>> Not Got tags");

			return null;
		}
	}

	private boolean tagValidate(String tag) {
		boolean validate = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z -]+$");
		Matcher matcher = pattern.matcher(tag);
		if (tag.length() > 7 && tag.length() < 45) {
			if (matcher.find()) {
				validate = true;
			}
		}
		return validate;
	}

	public DataModel<Product> filterProducts(DataModel<Product> dataModel, String tag) {
		if (tagValidate(tag)) {
			List<Product> list = new ArrayList<Product>();
			for (Product p : dataModel) {
				for (Tag filters : p.getTagList()) {
					if (tag.equals(filters.getName())) {
						list.add(p);
					}
				}
			}
			dataModel = new ListDataModel<Product>(list);
			return dataModel;
		}
		return null;
	}

}
