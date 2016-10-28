package com.genesisY.nbGardens.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.SortingService;
import com.genesisY.nbGardensCatalogue.entities.Product;

@Named("sort")
@RequestScoped

public class SortController {

	private String sorter;
	@Inject
	private ProductsController productsController;

	@Inject
	private SortingService sortingService;

	@SuppressWarnings("unchecked")
	public void sort(AjaxBehaviorEvent abe) {
		String sort = getSorter();
		System.out.println(">>>>>>>>>>> " + sort);
		switch(sort){
		case "Price High to Low" :
			productsController.setDataModel(sortingService.sortHighToLow(productsController.getDataModel2()));
			break;
		case "Price Low to High" :
			productsController.setDataModel(sortingService.sortLowToHigh(productsController.getDataModel2()));
			break;
		case "Rating" :
			productsController.setDataModel(sortingService.sortByRating(productsController.getDataModel2()));
			break;
		}
	}

	public String sortByHighToLow() {
		StringBuilder builder = new StringBuilder();
		return "subcategory";
	}

	public void setSorter(String sorter) {
		this.sorter = sorter;
	}

	public String getSorter() {
		return sorter;
	}
	
	

}
