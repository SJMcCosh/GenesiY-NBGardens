package com.genesisY.nbGardens.controller;

import java.io.Serializable;
import java.util.Arrays;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardensCatalogue.entities.PaginationHelper;
import com.genesisY.nbGardensCatalogue.entities.Product;

@SuppressWarnings("serial")
@Named("products")
@SessionScoped
public class ProductsController implements Serializable {

	@Inject
	private ProductService productService;
	private Product product;
	/**
	 * DataModel<Product>: Used for searches and on the home page
	 */
	private DataModel<Product> dataModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String category = "All";
	private String[] tagNameArray;
	private int quantityOfItemsSelected;
	/**
	 * DataModel<Product>: Used for navigation through categories
	 */
	private DataModel<Product> productModel = null;

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Views a specific product based on click
	 * @param p
	 * @return String: Opens the productpage for a specific product
	 */
	public String viewProduct(Product p) {
		product = productService.getProductByName(p.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>> Product Name = " + product.getName());
		return "productpage";
	}

	public String allProducts() {
		dataModel = getDataModel();
		return "subcategory";
	}

	/**
	 * Sets dataModel to one generated through pagination
	 * @return dataModel
	 */
	public DataModel<Product> getDataModel() {
		if (dataModel == null) {
			dataModel = getPagination().createPageDataModel();
		}
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Sets the models to null
	 */
	private void recreateModel() {
		dataModel = null;
		productModel = null;
	}

	/**
	 * Generates the previous page of products
	 * @return String: page listing products
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "subcategory";
	}

	/**
	 * Generates the next page of products
	 * @return String: page listing products
	 */
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "subcategory";
	}

	/**
	 * Gets a pagination
	 * @return PaginationHelper: for pagination
	 */
	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(12) {
				@Override
				public int getItemsCount() {
					return productService.getAllProducts(category).size();
				}
				@Override
				public int getItemsCount(String category) {
					return productService.getCategoryProducts(category).size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(productService.getAllProducts(category)
								.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								productService.getAllProducts(category).subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public DataModel<Product> createPageDataModel(String category) {
					try {
						return new ListDataModel<Product>(productService.getCategoryProducts(category)
								.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(productService.getCategoryProducts(category)
								.subList(getPageFirstItem(), getItemsCount(category)));
					}
				}
			};
		}
		return pagination;
	}

	public String[] getTagNameArray() {
		return tagNameArray;
	}

	public void setTagNameArray(String[] tagNameArray) {
		this.tagNameArray = tagNameArray;
	}

	/**
	 * Returns a string of the TagNameArray
	 * @return String
	 */
	public String getTagNameArrayInString() {
		return Arrays.toString(getTagNameArray());
	}

	/**
	 * Gets dataModel without changing it
	 */
	public DataModel<Product> getDataModel2() {
		return dataModel;
	}
	/**
	 * Gets productModel without changing it
	 */
	public DataModel<Product> getProductModel2() {
		return productModel;
	}

	public int getQuantityOfItemsSelected() {
		return quantityOfItemsSelected;
	}

	public void setQuantityOfItemsSelected(int quantityOfItemsSelected) {
		this.quantityOfItemsSelected = quantityOfItemsSelected;
	}

	/**
	 * Gets a list of products in a category based on input category
	 * @param String: category
	 * @return String: page of products in the category
	 */
	public String getCategoryProducts(String category) {
		setCategory(category);
		productModel = null;
		productModel = getProductModel();
		setCategory("All");
		return "subcategory";
	}

	/**
	 * Generates a DataModel<Product> and assigns it to productModel
	 * @return productModel
	 */
	public DataModel<Product> getProductModel() {
		if (productModel == null) {
			productModel = getPagination().createPageDataModel(category);
		}
		return productModel;
	}

	public void setProductModel(DataModel<Product> productModel) {
		this.productModel = productModel;
	}
	
	
	public String averageRatingImg(Double rating)
	{
		String imageURI = "";
		Integer starRating = rating.intValue();
		switch(starRating)
		{
			case(0) : imageURI = "img/Ratings/0.png";
						break;
			case(1) : imageURI = "img/Ratings/1.png";
						break;
			case(2) : imageURI = "img/Ratings/2.png";
						break;
			case(3) : imageURI = "img/Ratings/3.png";
						break;	
			case(4) : imageURI = "img/Ratings/4.png";
						break;			
			case(5) : imageURI = "img/Ratings/5.png";
						break;
		}
		
		return imageURI;
	}
	
}
