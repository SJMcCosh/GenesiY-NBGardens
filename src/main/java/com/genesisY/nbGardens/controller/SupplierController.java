package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.SupplierManager;
import com.genesisY.nbGardens.services.SupplierService;

@SuppressWarnings("serial")
@Named("suppliers")
@SessionScoped
public class SupplierController implements Serializable {

	@Inject
	private SupplierService supplierService;
	private Supplier supplier;
	private DataModel<Supplier> dataModel = null;
	private PaginationHelper pagination;
	private int selected;

	/*
	 * public DataModel<Supplier> getDataModel() { return dataModel; }
	 */

	public void setDataModel(DataModel<Supplier> dataModel) {
		this.dataModel = dataModel;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String viewSuppliers() {
		dataModel = getDataModel();
		return "viewsupplier";
	}

	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(15) {
				@Override
				public int getItemsCount() {
					return supplierService.viewSuppliers().size();
				}

				@Override
				public DataModel<Supplier> createPageDataModel() {
					try {
						return new ListDataModel<Supplier>(supplierService.viewSuppliers().subList(getPageFirstItem(),
								getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Supplier>(
								supplierService.viewSuppliers().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	public DataModel<Supplier> getDataModel() {
		if (dataModel == null) {
			dataModel = getPagination().createPageDataModel();
		}
		return dataModel;
	}

	private void updateCurrentItem() {
		int count = supplierService.viewSuppliers().size();
		if (selected >= count) {
			selected = count - 1;
			if (pagination.getPageFirstItem() >= count) {
				pagination.previousPage();
			}
		}
		if (selected >= 0) {
			try {
				setSupplier(supplierService.viewSuppliers().subList(selected, selected + 1).get(0));
			} catch (Exception e) {
				setSupplier(supplierService.viewSuppliers().subList(selected, count).get(0));
			}
		}
	}

	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "viewsupplier";
	}

	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "viewsupplier";
	}

	private void recreateModel() {
		dataModel = null;
	}
}
