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
	private ProductsController productsController;
	@Inject
	private TagService tagService;
	@Inject
	private FilterService filterService;
	private DataModel<Product> dataModel;
	private int selected;
	private String category = "all";
	private short minimum = 0;
	private short maximum = 2000;
	private short lower;
	private short upper;
	private List<String> tags;

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
	 * Method to filter a product by tags.
	 */
	public void filterProductsByTag(AjaxBehaviorEvent abe) {
		String[] arr = productsController.getTagNameArrayInString().split(", ");
		System.out.println("---------------" + Arrays.toString(arr));
		System.out.println(minimum + " " + maximum);
		if (productsController.getProductModel2() != null) {		//Checks if it's on a list of products in a category or from a search
			dataModel = productsController.getProductModel2();
		} else {
			dataModel = productsController.getDataModel2();
		}
		ArrayList<String> tagList = new ArrayList<String>();		//Creates a list of tags based on the ones checked
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

		filterService.filterByTag(tagList, dataModel);				//Calls method to filter by tags
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
	 * Method to filter by price
	 */
	public void filterByPrice(AjaxBehaviorEvent abe) {
		System.out.println(">>>>>>>>>>>>>>>>hi");
		if (productsController.getProductModel2() != null) {		//Checks if it's on a list of products in a category or from a search
			dataModel = productsController.getProductModel2();
		} else {
			dataModel = productsController.getDataModel2();
		}
		setLower(minimum);
		setUpper(maximum);
		for (Product p : dataModel) {
			p.setToRender(true);
		}
		filterService.filterByPrice(dataModel, minimum, maximum);
	}

	private short getLower() {
		return lower;
	}

	private void setLower(short lower) {
		this.lower = lower;
	}

	private short getUpper() {
		return upper;
	}

	private void setUpper(short upper) {
		this.upper = upper;
	}

	private List<String> getTags() {
		return tags;
	}

	private void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public void load() {
		productsController.setTagModel(new ListDataModel<Tag>(tagService.getAllTags()));
	}

}
