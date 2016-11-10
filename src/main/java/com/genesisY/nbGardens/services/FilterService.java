package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;

import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Stateless
public class FilterService {
	
	/**
	 * Sets whether or not a product should render to true or false based on whether or not it contains the selected tags
	 * @param tagList - Takes in a list of String
	 * @param dataModel - takes in a Data Model of Product
	 * @return dataModel: returns a DataModel.
	 */
	public DataModel<Product> filterByTag(List<String> tagList, DataModel<Product> dataModel) {
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

	/**
	 * Sets whether or not to render a product based on whether or not it is within the specified price range.
	 * @param dataModel - takes in a Data Model of Product
	 * @param minimum - the smallest value. A short.
	 * @param maximum - the largest value. A short.
	 * @return dataModel - returns a DataModel
	 */
	public DataModel<Product> filterByPrice(DataModel<Product> dataModel, short minimum, short maximum) {
		for (Product p : dataModel) {
			if (p.getPrice() < minimum || p.getPrice() > maximum) {
				p.setToRender(false);
			}
		}
		return dataModel;
	}
	
	/**
	 * Sets whether or not to render a product based on whether or not it is within the specified rating range.
	 * @param dataModel - takes in a Data Model of Product
	 * @param minimum - the smallest value. A short.
	 * @param maximum - the largest value. A short.
	 * @return dataModel - returns a DataModel
	 */
	public DataModel<Product> filterByRating(DataModel<Product> dataModel, double lower, double upper) {
		for (Product p : dataModel) {
			if (p.getAverageRating() < lower || p.getAverageRating() > upper) {
				p.setToRender(false);
			}
		}
		return dataModel;
	}
}
