package com.genesisY.nbGardensCatalogue.entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Outline class connecting Categories and Products
 * @author Thomas Chatterjee
 *
 */

@Entity
@Table (name = "categoty_to_product_conn")
public class CategoryToProductConn {
	@ManyToOne
	@JoinColumn (name = "productID", nullable = false)
	@NotNull
	private Product product;
	@ManyToOne
	@JoinColumn (name = "category", nullable = false)
	@NotNull
	private Category category;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
