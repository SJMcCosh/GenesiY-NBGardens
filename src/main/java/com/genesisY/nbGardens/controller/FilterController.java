package com.genesisY.nbGardens.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.FilterService;
import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.TagService;
import com.genesisY.nbGardensCatalogue.entities.PaginationHelper;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.Tag;

@Named("filter")
@RequestScoped
public class FilterController {

	private String filter;
	@Inject
	private ProductsController productsController;
	@Inject
	private TagService tagService;
	@Inject
	private ProductService productService;
	@Inject
	private FilterService filterService;
	private DataModel<Product> dataModel;
	private int selected;
	private PaginationHelper pagination;
	private String category = "all";

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void filterProductsByTag(AjaxBehaviorEvent abe) {
		String[] arr = productsController.getTagNameArrayInString().split(", ");
		System.out.println("---------------" + Arrays.toString(arr));
		dataModel = productsController.getDataModel2();
		ArrayList<String> tagList = new ArrayList<String>();
		for (String l : arr) {
			if (l.startsWith("[")) {
				l = l.substring(1);
			}
			if (l.endsWith("]")) {
				l = l.substring(0, l.length() - 1);
			}
			tagList.add(l);
		}
		if (tagList.size() != 0 && tagList.get(0).equals("")) {
			for (Product p : dataModel) {
				p.setToRender(true);
			}
		}
		if (tagList.size() != 0 && !tagList.get(0).equals("")) {
			/*for (Product p : dataModel) {
				ArrayList<String> tags = new ArrayList<String>();
				for (Tag t : p.getTagList()) {
					tags.add(t.getName());
				}
				for (String filt : tagList) {
					if (!tags.contains(filt)) {
						p.setToRender(false);
					}
				}
			}*/
			filterService.filterByTag(tagList, dataModel);
		}
	}

	public void load() {
		productsController.setTagModel(new ListDataModel<Tag>(tagService.getAllTags()));

	}

	public DataModel<Product> getDataModel2() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		this.dataModel = dataModel;
	}

	private void recreateModel() {
		dataModel = null;
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "subcategory";
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "subcategory";
	}

	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(12) {
				@Override
				public int getItemsCount() {
					return productService.getAllProducts(category).size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(getDataModelAsList(getDataModel2())
								.subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								getDataModelAsList(getDataModel2()).subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	public void setPagination(PaginationHelper pagination) {
		this.pagination = pagination;
	}

	public DataModel<Product> getDataModel() {
		if (dataModel != null) {
			dataModel = getPagination().createPageDataModel();
		}
		return dataModel;
	}

	private List<Product> getDataModelAsList(DataModel<Product> dataModel) {
		List<Product> products = new ArrayList<Product>();
		for (Product p : dataModel) {
			products.add(p);
		}
		return products;
	}

}
