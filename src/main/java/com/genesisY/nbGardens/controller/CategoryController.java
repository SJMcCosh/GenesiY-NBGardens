package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.CategoryService;
import com.genesisY.nbGardensCatalogue.entities.Category;

@SuppressWarnings("serial")
@Named("category")
@SessionScoped
public class CategoryController implements Serializable {

	private DataModel<Category> catModel;
	@Inject
	private CategoryService catService;

	public DataModel<Category> getCatModel() {
		return catModel;
	}

	public void setCatModel(DataModel<Category> catModel) {
		this.catModel = catModel;
	}

	/**
	 * Gets all the categories that are associated with a product
	 * @return String : the page department
	 */
	public String getAllCategories() {
		catModel = new ListDataModel<>(catService.getAllCategories());
		return "department";
	}

}
