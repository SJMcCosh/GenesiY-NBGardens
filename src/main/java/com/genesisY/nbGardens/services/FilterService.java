package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Stateless
public class FilterService {

	public DataModel<Product> filterByTag(List<String> tags, DataModel<Product> dataModel) {
		for (Product p : dataModel) {
			List<String> tagList = new ArrayList<String>();
			for(Tag tag: p.getTagList()){
				tagList.add(tag.getName());
			}
			for (String t : tags) {
				if (!tagList.contains(t)) {
					p.setToRender(false);
				}
			}
		}
		return null;
	}
}
