package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.services.ProductService;

@SuppressWarnings("serial")
@Named("productAdd")
@SessionScoped
public class AddProductController implements Serializable {

	@Inject
	private ProductService productService;
	private DataModel<Product> dataModel = null;
	private Integer productID;
	private String name;
	private Double price;
	private String desc;
	private String category;
	private Integer stock;
	private String product;
	private Double weight;
	private Double size;
	private Double averageRating;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public void createNewProduct() {
		productService.addProduct(productID, name, price, desc, category, stock, product, size, weight, averageRating);

	}

}