package com.genesisY.nbGardens.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.TagService;
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

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void filterProducts(AjaxBehaviorEvent abe) {
		String[] arr = productsController.getTagNameArrayInString().split(", ");
		System.out.println("---------------" + Arrays.toString(arr));
		DataModel<Product> dataModel = new ListDataModel<Product>(productService.getAllProducts("all"));
		productsController.setDataModel(dataModel);
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
		System.out.println(";;;;;;;;;;;;;;" + tagList.toString() + tagList.size() +tagList.get(0));
		if (tagList.size() != 0 && !tagList.get(0).equals("")) {
			for (String filt : tagList) {
				productsController.setDataModel(tagService.filterProducts(dataModel, filt));
				dataModel = productsController.getDataModel2();
			}
		}
	}

	public void load() {

		productsController.setTagModel(new ListDataModel<Tag>(tagService.getAllTags()));

	}

}
