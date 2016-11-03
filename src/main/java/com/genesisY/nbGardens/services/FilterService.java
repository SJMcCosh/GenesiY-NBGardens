package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Stateless
public class FilterService {

	public DataModel<Product> filterByTag(List<String> tagList, DataModel<Product> dataModel) {
		if (tagList.size() != 0 && tagList.get(0).equals("")) {
			for (Product p : dataModel) {
				p.setToRender(true);
			}
		}
		if (tagList.size() != 0 && !tagList.get(0).equals("")) {
			for (Product p : dataModel) {
				List<String> tags = new ArrayList<String>();
				for (Tag tag : p.getTagList()) {
					tags.add(tag.getName());
				}
				for (String t : tagList) {
					if (!tags.contains(t)) {
						p.setToRender(false);
					}
				}
			}
		}
		return dataModel;
	}

	public DataModel<Product> filterByPrice(DataModel<Product> dataModel, short minimum, short maximum) {
		for (Product p : dataModel) {
			if (p.getPrice() < minimum || p.getPrice() > maximum) {
				p.setToRender(false);
			}
		}
		return dataModel;
	}
}
