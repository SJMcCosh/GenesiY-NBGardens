package com.genesisY.nbGardensCatalogue.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Karrus 28/09/2016
 *
 */

@Entity
@Table(name = "productTagLine")
public class ProductTagLine {

	@ManyToOne
	@JoinColumn(name = "productID_fk", nullable = false)
	private long productId;

	@OneToOne
	@JoinColumn(name = "productID_fk", nullable = false)
	private long tagId;

	public ProductTagLine() {

	}

	/**
	 * @param productId
	 * @param tagId
	 */
	public ProductTagLine(long productId, long tagId) {
		this.productId = productId;
		this.tagId = tagId;
	}

	public void setProductId(long vproductId) {
		this.productId = vproductId;
	}

	public void setTagId(long vtagId) {
		this.tagId = vtagId;
	}

	public long getProductId() {

		return productId;
	}

	public long getTagId() {

		return tagId;
	}

}
