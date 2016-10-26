package com.genesisY.nbGardens.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.TagService;
import com.genesisY.nbGardensCatalogue.entities.Tag;


@Named ("filter")
@RequestScoped
public class FilterController{
	
	String filter;
	@Inject private ProductsController pController;
	@Inject private TagService tagService;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public void filterProducts(AjaxBehaviorEvent abe) {
		
	}
	
	public void load(){
		
		pController.setTagModel( new ListDataModel<Tag>(tagService.getAllTags()));
		
	}

}
