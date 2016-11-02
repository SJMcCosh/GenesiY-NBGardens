package com.genesisY.nbGardens.controller;


import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.SortingService;

@Named("sort")
@RequestScoped

public class SortController {

	private String sorter;
	@Inject
	private ProductsController productsController;

	@Inject
	private SortingService sortingService;

	/**
	 * Allows a customer to sort the results of products depending on which type of sorting that is going on
	 */
	public void sort() {
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

	public void setSorter(String sorter) {
		this.sorter = sorter;
	}

	public String getSorter() {
		return sorter;
	}
}
