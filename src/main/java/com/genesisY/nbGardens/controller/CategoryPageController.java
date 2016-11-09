package com.genesisY.nbGardens.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardensCatalogue.entities.PaginationHelper;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@SuppressWarnings("serial")
@Named("catpage")
@SessionScoped
public class CategoryPageController implements Serializable {

	@Inject
	private ProductService productService;
	@Inject
	private ProductsController productController;
	private Product product;
	/**
	 * DataModel<Product>: Used for searches and on the home page
	 */
	private DataModel<Product> dataModel = null;
	/**
	 * DataModel<Product>: Used for navigation through categories
	 */
	private DataModel<Product> productModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String category = "All";
	private String[] tagNameArray;
	private int quantityOfItemsSelected;
	private DataModel<Tag> tagModel = null;
	private DataModel<Product> allProductModel = null;
	private DataModel<Product> wholeProductModel = null;
	private String department;

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
	 * 
	 * @param p
	 * @return String: Opens the productpage for a specific product
	 */
	public String viewProduct(Product p) {
		productController.viewProduct(p);
		for (Product prod: allProductModel){
			prod.setToRender(true);
		}
		return "productpage";
	}

	public String allProducts(String category, String department) {
		setCategory(category);
		setDepartment(department);
		allProductModel = new ListDataModel<Product>(productService.getAllProducts(getCategory(), getDepartment()));
		List<Product> products = new ArrayList<Product>();
		for (Product p : allProductModel) {
			products.add(p);
		}
		wholeProductModel = new ListDataModel<Product>(products);
		dataModel = getDataModel();
		setProductModel(dataModel);
		for (Product p: wholeProductModel){
			p.setToRender(true);
		}
		return "subcategory";
	}

	/**
	 * Sets dataModel to one generated through pagination
	 * 
	 * @return dataModel
	 */
	public DataModel<Product> getDataModel() {
		dataModel = getPagination().createPageDataModel();

		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
		setProductModel(this.dataModel);
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
	 * 
	 * @return String: page listing products
	 */
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "subcategory";
	}

	/**
	 * Generates the next page of products
	 * 
	 * @return String: page listing products
	 */
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "subcategory";
	}

	/**
	 * Gets a pagination
	 * 
	 * @return PaginationHelper: for pagination
	 */
	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(12) {
				@Override
				public int getItemsCount() {
					return productService.getAllProducts(category, department).size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						List<Product> products = new ArrayList<Product>();
						for (Product p : getWholeProductModel()) {
							products.add(p);
						}
						return new ListDataModel<Product>(
								products.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						List<Product> products = new ArrayList<Product>();
						for (Product p : getWholeProductModel()) {
							products.add(p);
						}
						return new ListDataModel<Product>(products.subList(getPageFirstItem(), getItemsCount()));
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
	 * 
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
	public DataModel<Product> getProductModel() {
		System.out.println("gettingmodel " + productModel);
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
	 * 
	 * @param String:
	 *            category
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
	 * 
	 * @return productModel
	 */

	public void setProductModel(DataModel<Product> productModel) {
		this.productModel = productModel;
	}

	public String averageRatingImg(Double rating) {
		String imageURI = "";
		Integer starRating = rating.intValue();
		switch (starRating) {
		case (0):
			imageURI = "img/Ratings/0.png";
			break;
		case (1):
			imageURI = "img/Ratings/1.png";
			break;
		case (2):
			imageURI = "img/Ratings/2.png";
			break;
		case (3):
			imageURI = "img/Ratings/3.png";
			break;
		case (4):
			imageURI = "img/Ratings/4.png";
			break;
		case (5):
			imageURI = "img/Ratings/5.png";
			break;
		}

		return imageURI;
	}

	public DataModel<Tag> getTagModel() {
		return tagModel;
	}

	public void setTagModel(DataModel<Tag> tagModel) {
		this.tagModel = tagModel;
	}

	public DataModel<Product> getAllProductModel() {
		return allProductModel;
	}

	public void setAllProductModel(DataModel<Product> allProductModel) {
		this.allProductModel = allProductModel;
		setDataModel(pagination.createPageDataModel());
	}

	public DataModel<Product> getWholeProductModel() {
		return wholeProductModel;
	}

	public void setWholeProductModel(DataModel<Product> wholeProductModel) {
		this.wholeProductModel = wholeProductModel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
