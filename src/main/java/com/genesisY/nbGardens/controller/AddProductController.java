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
	private Product product;
	private int productID;
	private String name;
	private Double price;
	private String desc;
	private String category;
	private Integer stock;
	private String supplier;
	private Double weight;
	private Double size;
	private Double averageRating;

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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

		product  = new Product(productID, name, price, desc, category, stock, supplier, size, weight, averageRating);
		productService.addProduct(product);
		System.out.println(">>>> " + productID);
		System.out.println(">>>> " + name);
		System.out.println(">>>> " + price);
		System.out.println(">>>> " + desc);
		System.out.println(">>>> " + category);
		System.out.println(">>>> " + stock);
		System.out.println(">>>> " + supplier);
		System.out.println(">>>> " + size);
		System.out.println(">>>> " + weight);
		System.out.println(">>>> " + averageRating);
	}
	
	

}