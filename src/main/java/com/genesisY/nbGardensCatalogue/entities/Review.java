package com.genesisY.nbGardensCatalogue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Review class outline
 * @author Brian McLaughlin
 */
@Entity
@Table(name = "review")
public class Review {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rating", nullable = false)
	@NotNull
	private double rating;

	@Column(name = "reviewtext", length = 225)
	@Size(min = 2, max = 225)
	private String reviewText;
	
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private int customerid;

	@ManyToOne
	@JoinColumn(name = "productid_fk", nullable = false)
	@NotNull
	private int fk_ProductID;

	/**
	 * @param rating
	 * @param reviewText
	 * @param fk_ProductID
	 */
	public Review(double rating, String reviewText) {
		this.rating = rating;
		this.reviewText = reviewText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewtext() {
		return reviewText;
	}

	public void setReviewtext(String reviewtext) {
		this.reviewText = reviewtext;
	}

	public int getFk_ProductID() {
		return fk_ProductID;
	}

	public void setFk_ProductID(int fk_ProductID) {
		this.fk_ProductID = fk_ProductID;
	}

}
