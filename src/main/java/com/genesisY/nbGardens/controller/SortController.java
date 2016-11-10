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
	private CategoryPageController categoryPageController;

	@Inject
	private SortingService sortingService;

	/**
	 * Allows a customer to sort the results of products depending on which type of sorting that is going on - specifically for navigating through a department
	 */
	public void sort() {
		String sort = getSorter();
		switch(sort){
		case "Price High to Low" :
			categoryPageController.setWholeProductModel(sortingService.sortHighToLow(categoryPageController.getWholeProductModel()));
			break;
		case "Price Low to High" :
			categoryPageController.setWholeProductModel(sortingService.sortLowToHigh(categoryPageController.getWholeProductModel()));
			break;
		case "Rating" :
			categoryPageController.setWholeProductModel(sortingService.sortByRating(categoryPageController.getWholeProductModel()));
			break;
		}
	}
	/**
	 * Method for sorting a search
	 */
	public void searchSort() {
		String sort = getSorter();
		switch(sort){
		case "Price High to Low" :
			categoryPageController.setDataModel(sortingService.sortHighToLow(categoryPageController.getDataModel2()));
			break;
		case "Price Low to High" :
			categoryPageController.setDataModel(sortingService.sortLowToHigh(categoryPageController.getDataModel2()));
			break;
		case "Rating" :
			categoryPageController.setDataModel(sortingService.sortByRating(categoryPageController.getDataModel2()));
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
