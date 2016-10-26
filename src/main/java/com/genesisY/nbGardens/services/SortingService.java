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
	 * Method sorts products returned by price
	 * 
	 * @param dataModel
	 *            list of products to sort
	 */
	@SuppressWarnings("unchecked")
	public DataModel<Product> sortLowToHigh(DataModel<Product> dataModel) {
		List<Product> list = new ArrayList<Product>();
		for (Product p: dataModel){
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

	public DataModel<Product> sortHighToLow(DataModel<Product> dataModel) {
		List<Product> list = new ArrayList<Product>();
		for (Product p: dataModel){
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
		return dataModel;
	}
	
	public DataModel<Product> sortByRating(DataModel<Product> dataModel){
		List<Product> list = new ArrayList<Product>();
		for (Product p: dataModel){
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
