package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;


@Named("search")
@SessionScoped
public class SearchController implements Serializable{

	@Inject
	//TODO: inject in the search service layer bean
	 
	public String search(String product){
		//TODO: get the serch result into the service layer bean
		return "subcategory";
	}
	
}
