package com.genesisY.nbGardens.controller;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardensCatalogue.entities.Review;

@Named("reviewcon")
@RequestScoped
public class ReviewController {

	@Inject
	private ProductsController productsController;
	@Inject
	private CategoryPageController categoryPageController;
	private DataModel<Review> dataModel = null;
	
	
	public void getReviews(){
		
		dataModel = new ListDataModel<Review>(productsController.getProduct().getReviews());
		
	}


	public DataModel<Review> getDataModel() {
		return dataModel;
	}


	public void setDataModel(DataModel<Review> dataModel) {
		this.dataModel = dataModel;
	}
	
	
	
}
