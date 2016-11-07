package com.genesisY.nbGardensCatalogue.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Product implements Comparable<Product> {

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
	
	@Column(name = "price", nullable = false)
	@NotNull
	private double price;
	
	@OneToMany
	private List<Category> categories;
	
	@OneToMany
	private List<Tag> tagList;
	
	@Column(name = "imageLocation", nullable = false, length = 1000)
	@NotNull
	@Size(min = 2, max = 1000)
	private String imageLocation;
	
	@OneToMany
	private List<Review> reviews; 
	
	/**
	 * To render it on the screen. Doesn't need to be sent to the database and default is that it renders.
	 */
	private boolean toRender = true;

	public Product() {

	}

	public Product(int id, String name, double averageRating, String description, String size, double weight, double price, List<Tag> tagList, String imageLocation, List<Review> reviews, List<Category> categories) {
		this.id = id;
		this.name = name;
		this.averageRating = averageRating;
		this.description = description;
		this.size = size;
		this.weight = weight;
		this.price = price;
		this.tagList = tagList;
		this.imageLocation = imageLocation;
		this.reviews = reviews;
		this.categories = categories;
	}

	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@Override
	public int compareTo(Product o) {
		
		return ((Double)this.getPrice()).compareTo(o.getPrice());
	}

	public boolean isToRender() {
		return toRender;
	}

	public void setToRender(boolean toRender) {
		this.toRender = toRender;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	

}
