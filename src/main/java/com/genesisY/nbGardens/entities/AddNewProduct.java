package com.genesisY.nbGardens.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@SessionScoped
public class AddNewProduct implements Serializable {

	@GeneratedValue
	private String productID;
	@NotNull
	@Size(min = 2, max = 255)
	private String name;
	@NotNull
	@Size(min = 2, max = 8)
	private BigDecimal price;
	private String desc;
	@NotNull
	@Size(min = 2, max = 255)
	private String category;
	@NotNull
	@Size(min = 2, max = 255)
	private String tags;
	@NotNull
	private int stock;
	@NotNull
	@Size(min = 2, max = 255)
	private String supplier;
	@NotNull
	private int size;
	@NotNull
	private Double weight;
	@NotNull
	private Double averageRating;

	 public AddNewProduct(String productID, String name, String desc, String category, int stock, String supplier, int size, double weight, double averageRating) {
	 
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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
