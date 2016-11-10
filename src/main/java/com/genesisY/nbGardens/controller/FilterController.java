package com.genesisY.nbGardens.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.FilterService;
import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.TagService;
import com.genesisY.nbGardensCatalogue.entities.PaginationHelper;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Named("filter")
@RequestScoped
public class FilterController {


	@Inject
	private CategoryPageController categoryPageController;
	@Inject
	private TagService tagService;
	@Inject
	private FilterService filterService;
	@Inject
	private SearchController searchController;
	private DataModel<Product> dataModel;
	private int selected;
	private String category = "all";
	private short minimum = 0;
	private short maximum = 2000;
	private double minrat = 0;
	private double maxrat = 5;

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	/**
	 * 
	 * @param abe
	 *            Method to filter a product by tags.
	 */
	public void filterProductsByTag(AjaxBehaviorEvent abe) {
		String[] arr = categoryPageController.getTagNameArrayInString().split(", ");
		categoryPageController.setWholeProductModel(categoryPageController.getAllProductModel());
		dataModel = categoryPageController.getWholeProductModel();
		ArrayList<String> tagList = new ArrayList<String>();			 // Creates a list of tags based on the ones checked
		for (String l : arr) {
			if (l.startsWith("[")) {
				l = l.substring(1);
			}
			if (l.endsWith("]")) {
				l = l.substring(0, l.length() - 1);
			}
			tagList.add(l);
		}
		for (Product p: dataModel){
			p.setToRender(true);
		}
		filterService.filterByTag(tagList, dataModel);					 // Calls method to filter by tags
	}

	public DataModel<Product> getDataModel2() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public short getMinimum() {
		return minimum;
	}

	public void setMinimum(short minimum) {
		this.minimum = minimum;
	}

	public short getMaximum() {
		return maximum;
	}

	public void setMaximum(short maximum) {
		this.maximum = maximum;
	}

	/**
	 * 
	 * @param abe
	 *            Method to filter by price
	 */
	public void filterByPrice(AjaxBehaviorEvent abe) {
		categoryPageController.setWholeProductModel(categoryPageController.getAllProductModel());
		dataModel = categoryPageController.getWholeProductModel();
		for (Product p : dataModel) {
			p.setToRender(true);
		}
		filterService.filterByPrice(dataModel, minimum, maximum);
	}

	public void load() {
		String cat = categoryPageController.getCategory();
		categoryPageController.setTagModel(new ListDataModel<Tag>(tagService.getAllTags(cat)));
	}

	public double getMinrat() {
		return minrat;
	}

	public void setMinrat(double minrat) {
		this.minrat = minrat;
	}

	public double getMaxrat() {
		return maxrat;
	}

	public void setMaxrat(double maxrat) {
		this.maxrat = maxrat;
	}

	/**
	 * 
	 * @param abe
	 *            Method to filter by rating
	 */
	public void filterByRating(AjaxBehaviorEvent abe) {
		categoryPageController.setWholeProductModel(categoryPageController.getAllProductModel());
		dataModel = categoryPageController.getWholeProductModel();
		filterService.filterByRating(dataModel, minrat, maxrat);
	}
	
	public void searchLoad() {
		String term = searchController.getTerm();
		categoryPageController.setTagModel(new ListDataModel<Tag>(tagService.getSearchTags(term)));
	}

}
