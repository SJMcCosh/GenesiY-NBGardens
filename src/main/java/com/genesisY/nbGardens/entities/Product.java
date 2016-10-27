package com.genesisY.nbGardens.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Product outline
 * 
 * @author Sam Precious
 *
 */

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "productID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;

	@Column(name = "productName", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String name;

	@Column(name = "desc", nullable = false, length = 1000)
	@NotNull
	@Size(min = 2, max = 1000)
	private String desc;
		
	@Column(name = "price", nullable = false, length = 255)
	@NotNull
	private double price;
	
	private List<Category> catList;

	@Column(name = "supplier", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String supplier;
	
	@Column(name = "imgLoc", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String imageLocation;

	@Column(name = "spec", nullable = false, length = 255)
	@NotNull
	private String specification;
	
	@Column(name = "stockLevel", nullable = false)
	@NotNull
	private int stockLevel;

	@Column(name = "averageRating", nullable = false)
	@NotNull
	private Double averageRating;

	public Product(int id, String name, String description, String imageLocation, double price, String specification, int stockLevel, List<Category> catList) {
		this.productID = id;
		this.name = name;
		this.desc = description;
		this.imageLocation = imageLocation;
		this.price = price;
		this.specification = specification;
		this.stockLevel = stockLevel;
		this.catList = catList;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
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

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public List<Category> getCatList() {
		return catList;
	}

	public void setCatList(List<Category> catList) {
		this.catList = catList;
	}

}
