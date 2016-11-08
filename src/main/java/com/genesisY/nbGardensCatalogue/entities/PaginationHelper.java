package com.genesisY.nbGardensCatalogue.entities;

import javax.faces.model.DataModel;

public abstract class PaginationHelper {

	private int pageSize;
	private int page;

	public PaginationHelper(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the count of all products
	 * @return int: Count of all products
	 */
	public abstract int getItemsCount();

	/**
	 * Creates a data model of products
	 * @return DataModel<Product>
	 */
	public abstract DataModel<Product> createPageDataModel();

	public int getPageFirstItem() {
		return page * pageSize;
	}

	public int getPageLastItem() {
		int i = getPageFirstItem() + pageSize - 1;
		int count = getItemsCount() - 1;
		if (count > i)
			;
		if (i < 0)
			i = 0;
		return i;
	}

	public boolean isHasNextPage() {
		return (page + 1) * pageSize + 1 <= getItemsCount();
	}

	public boolean isHasPreviousPage() {
		return page > 0;
	}

	public void nextPage() {
		if (isHasNextPage())
			page++;
	}

	public void previousPage() {
		if (isHasPreviousPage())
			page--;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Creates a data model of products based on a particular category
	 * @param String: category
	 * @return DataModel<Product>
	 */
	public abstract DataModel<Product> createPageDataModel(String category);

	/**
	 * Gets the count of all products in a particular category
	 * @param String: category
	 * @return int: count of items in a category
	 */
	public abstract int getItemsCount(String category);
}
