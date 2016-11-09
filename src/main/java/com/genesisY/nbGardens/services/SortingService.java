package com.genesisY.nbGardens.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.genesisY.nbGardensCatalogue.entities.Product;

@Stateless
public class SortingService {

	/**
	 * Method sorts products returned by price where the lowest priced product
	 * is at the top of the list
	 * 
	 * @param dataModel
	 *            list of products to sort
	 */
	@SuppressWarnings("unchecked")
	public DataModel<Product> sortLowToHigh(DataModel<Product> dataModel) {
		List<Product> list = new ArrayList<Product>();
		for (Product p : dataModel) {
			list.add(p);
		}
		list.sort(new Comparator<Product>() {

			@Override
			public int compare(Product arg0, Product arg1) {
				// TODO Auto-generated method stub
				return Double.compare(arg0.getPrice(), arg1.getPrice());
			}

		});
		dataModel = new ListDataModel<>(list);
		return dataModel;
	}

	/**
	 * Sorts the product list from high to low based on the price where the
	 * highest priced product is at the top of the list
	 * 
	 * @param dataModel
	 *            : the product datamodel that needs to be sorted
	 * @return DataModel<Product> : the sorted datamodel for the frontend to
	 *         display
	 */

	public DataModel<Product> sortHighToLow(DataModel<Product> dataModel) {
		System.out.println("-------- sorting");
		List<Product> list = new ArrayList<Product>();
		for (Product p : dataModel) {
			list.add(p);
		}
		list.sort(new Comparator<Product>() {

			@Override
			public int compare(Product arg0, Product arg1) {
				// TODO Auto-generated method stub
				return Double.compare(arg1.getPrice(), arg0.getPrice());
			}

		});
		dataModel = new ListDataModel<>(list);
		System.out.println("finishedsorting");
		return dataModel;
	}

	/**
	 * Sorts the product list from based on the rating of the product, the
	 * highest rated products will be at the top of the list
	 * 
	 * @param dataModel
	 *            : the product datamodel that needs to be sorted
	 * @return DataModel<Product> : the sorted datamodel for the frontend to
	 *         display
	 */
	public DataModel<Product> sortByRating(DataModel<Product> dataModel) {
		List<Product> list = new ArrayList<Product>();
		for (Product p : dataModel) {
			list.add(p);
		}
		list.sort(new Comparator<Product>() {

			@Override
			public int compare(Product arg0, Product arg1) {
				// TODO Auto-generated method stub
				return Double.compare(arg1.getAverageRating(), arg0.getAverageRating());
			}

		});
		dataModel = new ListDataModel<>(list);
		return dataModel;
	}
}
