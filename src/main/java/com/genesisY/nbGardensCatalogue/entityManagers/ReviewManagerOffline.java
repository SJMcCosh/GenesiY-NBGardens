/**
 * Class that is a allows the Reviews Entities to be created, read or updated
 * @author Samuel McCosh
 */
package com.genesisY.nbGardensCatalogue.entityManagers;

import com.genesisY.nbGardensCatalogue.entities.Review;

public class ReviewManagerOffline implements ReviewRepository {

	public void createReview(Review x){
		// add Review to database
		// ReviewID = generated number 
		// ReviewName = input
	}
	
	public void readReview(Review x){
		// read Review from database
		// search for ReviewID from input
		// display Review name
	}
	
	public void updateReview(Review x){
		// search for ReviewID from input
		// new name = input
		// display Review new name
	}
	
	public void archiveReview(Review x){
		// search for ReviewID from input
		// set the status of the Review to "Inactive"
		// display confirmation message
	}
	
}
