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

	@Column(name = "averageRating", nullable = false)
	@NotNull
	private double averageRating;

	@Column(name = "productName", nullable = false, length = 1000)
	@NotNull
	@Size(min = 2, max = 1000)
	private String description;

	@Column(name = "productName", nullable = false, length = 255)
	@NotNull
	@Size(min = 2, max = 255)
	private String size;

	@Column(name = "averageRating", nullable = false)
	@NotNull
	private double weight;
	@Column(name = "tagID", nullable = false)
	@NotNull
	private List<Tag> tags;

	public Product() {
		
	}

	public Product(String name, double averageRating, String description, String size, double weight) {
		this.name = name;
		this.averageRating = averageRating;
		this.description = description;
		this.size = size;
		this.weight = weight;
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

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public List<Tag> getTags(){
		return tags;
	}
	
	public void setTags(List<Tag> tags){
		this.tags = tags;
	}

}
