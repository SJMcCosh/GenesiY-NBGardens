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
	private int id;

	@Column(name = "productName", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String name;

	@Column(name = "productName", nullable = false, length = 1000)
	@NotNull
	@Size(min = 2, max = 1000)
	private String description;
	
	@Column(name = "tagID", nullable = false)
	@NotNull
	private List<Tag> tags;
	
	private String imageLocation;
	
	private double price;
	
	private String specification;
	
	private int stockLevel;

	public Product(String productID, String name, Double price, String desc, String category, Integer stock, String supplier, Double size, Double weight, Double averageRating) {
		
	}

	public Product(int id, String name, String description, String imageLocation, double price, String specification, int stockLevel) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageLocation = imageLocation;
		this.price = price;
		this.specification = specification;
		this.stockLevel = stockLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

}
