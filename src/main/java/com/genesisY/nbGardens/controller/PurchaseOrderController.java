package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.entityManagers.offline.PurchaseOrderManagerOffline;
import com.genesisY.nbGardens.services.PurchaseOrderService;
import com.genesisY.nbGardens.services.SupplierService;

@SuppressWarnings("serial")
@Named("purchase")
@SessionScoped
public class PurchaseOrderController implements Serializable {

	@Inject
	private PurchaseOrderService purchaseOrderService;
	private Supplier supplier;
	private DataModel<PurchaseOrder> dataModel = null;
	private PaginationHelper pagination;
	private int selected;
	private String name;
	private String phone;
	private String email;
	private Address address;
	private PurchaseOrder purchaseOrder;
	private DataModel<Product> purchaseProdList; 
	 

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	/*
	 * setters and getters for adding supplier
	 */
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * public DataModel<Supplier> getDataModel() { return dataModel; }
	 */

	public void setDataModel(DataModel<PurchaseOrder> dataModel) {
		this.dataModel = dataModel;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public String viewPurchaseOrders() {
		dataModel = getDataModel();
		return "viewsupplier";
	}


	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(15) {
				@Override
				public int getItemsCount() {
					return purchaseOrderService.viewPurchaseOrders().size();
				}

				@Override
				public DataModel<PurchaseOrder> createPageDataModel() {
					try {
						return new ListDataModel<PurchaseOrder>(purchaseOrderService.viewPurchaseOrders().subList(getPageFirstItem(),
								getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<PurchaseOrder>(
								purchaseOrderService.viewPurchaseOrders().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	public DataModel<PurchaseOrder> getDataModel() {
		if (dataModel == null) {
			dataModel = getPagination().createPageDataModel();
		}
		return dataModel;
	}

	private void updateCurrentItem() {
		int count = purchaseOrderService.viewPurchaseOrders().size();
		if (selected >= count) {
			selected = count - 1;
			if (pagination.getPageFirstItem() >= count) {
				pagination.previousPage();
			}
		}
		if (selected >= 0) {
			try {
				setPurchaseOrder(purchaseOrderService.viewPurchaseOrders().subList(selected, selected + 1).get(0));
			} catch (Exception e) {
				setPurchaseOrder(purchaseOrderService.viewPurchaseOrders().subList(selected, count).get(0));
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
		return "approvedproductorders";
	}

	private void recreateModel() {
		dataModel = null;
	}

	public String onLoad() {
		dataModel = new ListDataModel<PurchaseOrder>(purchaseOrderService.viewPurchaseOrders());
		return "approvedproductorders";
	}
	
}