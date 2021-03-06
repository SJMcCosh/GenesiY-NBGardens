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
import com.genesisY.nbGardensCatalogue.entities.Tag;

@SuppressWarnings("serial")
@Named("products")
@SessionScoped
public class ProductsController implements Serializable {

	@Inject
	private ProductService productService;
	private Product product;
	private DataModel<Product> dataModel = null;
	private DataModel<Tag> tagModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String category = "all";
	private Tag[] tagArray;
	private String[] tagNameArray;
	private String lowerBound;
	private String upperBound;
	private int quantityOfItemsSelected;


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

	public DataModel<Tag> getTagModel() {
		return tagModel;
	}

	public void setTagModel(DataModel<Tag> tagModel) {
		this.tagModel = tagModel;
	}

	public String viewProduct(Product p) {
		product = productService.getProductByName(p.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>> Product Name = " + product.getName());
		return "productpage";
	}

	public String allProducts() {
		dataModel = getDataModel();
		return "subcategory";
	}

	@SuppressWarnings("unchecked")
	public DataModel<Product> getDataModel() {
		if (dataModel == null){
			dataModel = getPagination().createPageDataModel();
		}
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public String view() {
		return "productpage";
	}

	public String view(long id) {

		return "productpage";
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

	private void recreateModel(){
		dataModel = null;
	}
	
	public String previous(){
		getPagination().previousPage();
		recreateModel();
		return "subcategory";
	}
	
	public String next(){
		getPagination().nextPage();
		recreateModel();
		return "subcategory";
	}
	
	@SuppressWarnings("unused")
	private void updateCurrentItem(){
		int count = productService.getAllProducts(category).size();
		if (selected >= count){
			selected = count - 1;
			if (pagination.getPageFirstItem() >= count){
				pagination.previousPage();
			}
		}
		if (selected >= 0){
			try{
				setProduct(productService.getAllProducts(category).subList(selected, count).get(0));
			} catch (Exception e){
				setProduct(productService.getAllProducts(category).subList(selected, count).get(0));
			}
		}
	}
	
	public PaginationHelper getPagination(){
		if (pagination == null){
			pagination = new PaginationHelper(12){
				@Override
				public int getItemsCount(){
					return productService.getAllProducts(category).size();
				}
				
				@Override
				public DataModel<Product> createPageDataModel(){
					try{
						return new ListDataModel<Product>(productService.getAllProducts(category).subList(getPageFirstItem(), getPageFirstItem()+ getPageSize()));
					} catch(Exception e){
						return new ListDataModel<Product>(productService.getAllProducts(category).subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	public Tag[] getTagArray() {
		Tag[] tags = new Tag[tagModel.getRowCount()];
		int count = 0;
		for(Tag tag: tagModel){
			tags[count]=tag;
			count++;
		}
		return tags;
	}

	public void setTagArray(Tag[] tagArray) {
		this.tagArray = tagArray;
	}

	public String[] getTagNameArray() {
		return tagNameArray;
	}

	public void setTagNameArray(String[] tagNameArray) {
		this.tagNameArray = tagNameArray;
	}
	
	public String getTagNameArrayInString(){
		return Arrays.toString(getTagNameArray());
	}
	public DataModel<Product> getDataModel2(){
		return dataModel;
	}

	public String getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	public String getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

	public int getQuantityOfItemsSelected() {
		return quantityOfItemsSelected;
	}

	public void setQuantityOfItemsSelected(int quantityOfItemsSelected) {
		this.quantityOfItemsSelected = quantityOfItemsSelected;
	}
}
