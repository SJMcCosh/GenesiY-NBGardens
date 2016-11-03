package com.genesisY.nbGardens.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.genesisY.nbGardensCatalogue.entities.BasketItem;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Review;
import com.genesisY.nbGardensCatalogue.entities.Tag;
import com.genesisY.nbGardensCatalogue.entityManagers.BasketManager;

@Stateless
public class BasketService {

	@Inject
	private BasketManager basketManager;

	private boolean validateProduct(Product product) {
		boolean validate = false;
		Pattern pattern1 = Pattern.compile("^[0-9a-zA-Z&.,'\"/ ()!�$%:;?*-]+&");
		Matcher matcher1 = pattern1.matcher(product.getDescription());
		if (!matcher1.find()) {
			return validate;
		}
		Pattern pattern2 = Pattern.compile("^[0-9a-zA-Z ()!',.-]+&");
		Matcher matcher2 = pattern2.matcher(product.getName());
		if (!matcher2.find()) {
			return validate;
		}
		Pattern pattern3 = Pattern.compile("^[0-9a-zA-Z/._-]+&");
		Matcher matcher3 = pattern3.matcher(product.getImageLocation());
		if (!matcher3.find()) {
			return validate;
		}
		
		validate = true;
		return validate;
	}

	@SuppressWarnings("unchecked")
	public List<BasketItem> getBasketItems() {
		try {
			System.out.println("At service");
			return basketManager.getBasketItems();
			/*
			 * if (basketManager.getProducts().size() != 0) {
			 * 
			 * System.out.println("Service Row Count: " +
			 * basketManager.getProducts().size()); //return
			 * basketManager.getProducts(); }else{ System.out.println(); return
			 * null; }
			 */
		} catch (NullPointerException npe) {
			System.out.println("Exception: " + npe.getStackTrace());
			return null;
		}

	}

	public void addProductToBasket(Product product, int quantity) {
		
			basketManager.addProductToCart(product, quantity);
		
	}

}
