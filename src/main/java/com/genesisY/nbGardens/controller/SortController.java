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
		System.out.println(">>>>>>>>>>> " + sort);
		switch(sort){
		case "Price High to Low" :
			categoryPageController.setAllProductModel(sortingService.sortHighToLow(categoryPageController.getAllProductModel()));
			break;
		case "Price Low to High" :
			categoryPageController.setAllProductModel(sortingService.sortLowToHigh(categoryPageController.getAllProductModel()));
			break;
		case "Rating" :
			categoryPageController.setAllProductModel(sortingService.sortByRating(categoryPageController.getAllProductModel()));
			break;
		}
	}
	/**
	 * Method for sorting a search
	 */
	public void searchSort() {
		String sort = getSorter();
		System.out.println(">>>>>>>>>>> " + sort);
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
