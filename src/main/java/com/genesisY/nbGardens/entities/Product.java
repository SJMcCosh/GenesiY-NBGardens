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

	@Column(name = "productDescription", nullable = false, length = 1000)
	@NotNull
	@Size(min = 2, max = 1000)
	private String desc;
	
	@Column(name = "tagID", nullable = false)
	@NotNull
	private List<Tag> tags;
	
	private String imageLocation;
	
	@Column(name = "price", nullable = false, length = 255)
	@NotNull
	private double price;
	
	
	private String specification;
	
	@Column(name = "stock", nullable = false)
	@NotNull
	private int stock;

	@Column(name = "category", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String category;

	@Column(name = "supplier", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String supplier;

	@Column(name = "size", nullable = false)
	@NotNull
	private Double size;

	@Column(name = "weight", nullable = false)
	@NotNull
	private Double weight;

	@Column(name = "averageRating", nullable = false)
	@NotNull
	private Double averageRating;

	public Product(int productID, String name, Double price, String desc, String category, Integer stock, String supplier, Double size, Double weight, Double averageRating) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.category = category;
		this.stock = stock;
		this.supplier = supplier;
		this.size = size;
		this.weight = weight;
		this.averageRating = averageRating;
	}

	public Product(int id, String name, String description, String imageLocation, double price, String specification, int stockLevel) {
		this.productID = id;
		this.name = name;
		this.desc = description;
		this.imageLocation = imageLocation;
		this.price = price;
		this.specification = specification;
		this.stock = stockLevel;
	}

	public int getId() {
		return productID;
	}

	public void setId(int id) {
		this.productID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String description) {
		this.desc = description;
	}
	
	public List<Tag> getTags(){
		return tags;
	}
	
	public void setTags(List<Tag> tags){
		this.tags = tags;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public int getStockLevel() {
		return stock;
	}

	public void setStockLevel(int stockLevel) {
		this.stock = stockLevel;
	}

}
