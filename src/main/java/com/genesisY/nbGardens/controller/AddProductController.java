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
	private String supplier;
	private Integer stock;
	private String imageLocation;
	private String specification;
	private Double averageRating;

	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public void createNewProduct() {
		product = new Product(productID, name, price, desc, supplier, imageLocation, specification, stock,
				averageRating);
		productService.addProduct(product);
		System.out.println(">>>> " + productID);
		System.out.println(">>>> " + name);
		System.out.println(">>>> " + price);
		System.out.println(">>>> " + desc);
		System.out.println(">>>> " + supplier);
		System.out.println(">>>> " + imageLocation);
		System.out.println(">>>> " + specification);
		System.out.println(">>>> " + stock);
		System.out.println(">>>> " + averageRating);
	}
}