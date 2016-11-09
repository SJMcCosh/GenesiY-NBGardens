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

	private String filter;
	@Inject
	private CategoryPageController categoryPageController;
	@Inject
	private TagService tagService;
	@Inject
	private FilterService filterService;
	private DataModel<Product> dataModel;
	private int selected;
	private String category = "all";
	private short minimum = 0;
	private short maximum = 2000;
	private short lower = 0;
	private short upper = 2000;
	private List<String> tags = new ArrayList<String>();
	private double minrat = 0;
	private double maxrat = 5;
	private double least = 0;
	private double most = 5;

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

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
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
		setTags(tagList);
		for (Product p: dataModel){
			p.setToRender(true);
		}
		filterService.filterByTag(tagList, dataModel);					 // Calls method to filter by tags
		filterService.filterByRating(dataModel, least, most);
		filterService.filterByPrice(dataModel, lower, upper);
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
		setLower(minimum);
		setUpper(maximum);
		filterService.filterByPrice(dataModel, minimum, maximum);
		filterService.filterByTag(tags, dataModel);	
		filterService.filterByRating(dataModel, least, most);
	}

	private List<String> getTags() {
		return tags;
	}

	private void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void load() {
		categoryPageController.setTagModel(new ListDataModel<Tag>(tagService.getAllTags()));
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
		setLeast(minrat);
		setMost(maxrat);
		filterService.filterByRating(dataModel, minrat, maxrat);
		filterService.filterByTag(tags, dataModel);	
		filterService.filterByPrice(dataModel, lower, upper);
	}

	public short getLower() {
		return lower;
	}

	public void setLower(short lower) {
		this.lower = lower;
	}

	public short getUpper() {
		return upper;
	}

	public void setUpper(short upper) {
		this.upper = upper;
	}

	public double getLeast() {
		return least;
	}

	public void setLeast(double least) {
		this.least = least;
	}

	public double getMost() {
		return most;
	}

	public void setMost(double most) {
		this.most = most;
	}

}
