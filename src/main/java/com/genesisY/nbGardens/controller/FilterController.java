package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Tag;

@Named ("filter")
@SessionScoped 

public class FilterController implements Serializable{
	
	
	private DataModel<Tag> filters;
	
	
	
	public DataModel<Tag> getFilters() {
		return filters;
	}



	public void setFilters(DataModel<Tag> filters) {
		this.filters = filters;
	}



	public String filter(String filter) {
	
		//TODO link service layer
		
		return "subCategory";

	}

}
