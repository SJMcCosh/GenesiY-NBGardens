package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Category;

@Named("customer")
@SessionScoped
public class CategoryController implements Serializable{
	
	private DataModel<Category> catModel;

	public DataModel<Category> getCatModel() {
		return catModel;
	}

	public void setCatModel(DataModel<Category> catModel) {
		this.catModel = catModel;
	}
	
	

}
