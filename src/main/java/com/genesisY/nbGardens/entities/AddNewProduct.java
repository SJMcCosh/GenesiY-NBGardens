package com.genesisY.nbGardens.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.genesisY.nbGardens.entities.Product;

/**
 * Product outline
 * 
 * @author Sam Precious
 *
 */

@ManagedBean(name = "newproduct")
@RequestScoped
public class AddNewProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID", nullable = false)
	private String productID;
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "name", nullable = false)
	private String name;
	@NotNull
	@Column(name = "price", nullable = false)
	private Double price;
	@Column(name = "desc")
	private String desc;
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "category", nullable = false)
	private String category;
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "tag", nullable = false)
	private String tags;
	@NotNull
	@Column(name = "stock", nullable = false)
	private Integer stock;
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "supplier", nullable = false)
	private String supplier;
	@NotNull
	@Column(name = "size", nullable = false)
	private Double size;
	@NotNull
	@Column(name = "weight", nullable = false)
	private Double weight;
	@NotNull
	@Column(name = "avgRate", nullable = false)
	private Double averageRating;
	private DataModel<Product> dataModel = null;	
	private Product newProduct;

	public AddNewProduct(){
		
	}
	
	public AddNewProduct(String productID, String name, Double price, String desc, String category, Integer stock, String supplier,
			Double size, Double weight, Double averageRating) {
		this.productID = productID;
		this.name = name;
		this.desc = desc;
		this.size = size;
		this.weight = weight;
		this.averageRating = averageRating;
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

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
}
