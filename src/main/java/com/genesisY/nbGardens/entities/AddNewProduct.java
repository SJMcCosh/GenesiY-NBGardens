package com.genesisY.nbGardens.entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Product outline
 * 
 * @author Sam Precious
 *
 */

@ManagedBean(name = "newproduct")
@RequestScoped
public class AddNewProduct {

	@GeneratedValue
	@Column(name = "productID", nullable = false, length = 5)
	private String productID;
	
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 8)
	@Column(name = "price", nullable = false)
	private double price;
	
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
	@Column(name = "stock", nullable = false, length = 10)
	private int stock;
	
	@NotNull
	@Size(min = 2, max = 255)
	@Column(name = "supplier", nullable = false)
	private String supplier;
	
	@NotNull
	@Column(name = "size", nullable = false, length = 20)
	private int size;
	
	@NotNull
	@Column(name = "weight", nullable = false, length = 20)
	private double weight;
	
	@NotNull
	@Column(name = "avgRate", nullable = false, length = 20)
	private double averageRating;

	public AddNewProduct(){
		
	}
	
	public AddNewProduct(String productID, String name, String desc, String category, int stock, String supplier,
			int size, double weight, double averageRating) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
}
