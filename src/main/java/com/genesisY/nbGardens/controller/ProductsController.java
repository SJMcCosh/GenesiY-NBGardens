package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.PaginationHelper;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;
import com.genesisY.nbGardens.services.ProductService;
import com.genesisY.nbGardens.services.SupplierService;

@SuppressWarnings("serial")
@Named("products")
@SessionScoped
public class ProductsController implements Serializable {

	private Product product;
	private String price = "";
	private String name = "";
	private String description = "";
	private String specification = "";
	private DataModel<Product> dataModel = null;
	private PaginationHelper pagination;
	private int selected;
	private boolean status = true; 
	private DataModel<Supplier> dataSupplier = null;
	private boolean valid; 
	@Inject
	private ProductService productService;

	public String getAllProducts() {

		dataModel = new ListDataModel<Product>(productService.viewProducts());
		return "newpurchaseorder";
	}

	public String viewProduct(Product p) {
		product = productService.getProductByName(p.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>> Product Name = " + product.getName());
		setName(product.getName());
		setPrice(Double.toString(product.getPrice()));
		setDescription(product.getDesc());
		setSpecification(product.getSpecification());
		setStatus(product.isStatus());
		getDataSupplier(p);
		return "product";
	}

	public String onLoad() {
		dataModel = new ListDataModel<Product>(productService.getAllProducts());
		return "subcategory";
	}

	public String updateProduct() {

		product.setName(name);
		// product.setPrice(Double.parseDouble(price));
		product.setDesc(description);
		product.setSpecification(specification);
		System.out.println(">>>>>>>>>>>>" + getPrice());
		productService.updateProduct(product);

		return "product";
	}
	public String discontinueProduct(){ 
		product.setStatus(false);
		System.out.println(product.isStatus());
		productService.updateProduct(product);
		return "product"; 
	}
	public String invalidateProduct(){ 
		product.setValid(false);
		System.out.println(product.isValid());
		productService.updateProduct(product);
		return "product"; 
	}
	public String reactivateProduct(){ 
		product.setStatus(true);
		System.out.println(product.isStatus());
		productService.updateProduct(product);
		return "product"; 
	}

	public PaginationHelper getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelper(15) {
				@Override
				public int getItemsCount() {
					return productService.viewProducts().size();
				}

				@Override
				public DataModel<Product> createPageDataModel() {
					try {
						return new ListDataModel<Product>(productService.viewProducts().subList(getPageFirstItem(),
								getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(
								productService.viewProducts().subList(getPageFirstItem(), getItemsCount()));
					}
				}
			};
		}
		return pagination;
	}

	private void updateCurrentItem() {
		int count = productService.viewProducts().size();
		if (selected >= count) {
			selected = count - 1;
			if (pagination.getPageFirstItem() >= count) {
				pagination.previousPage();
			}
		}
		if (selected >= 0) {
			try {
				setProduct(productService.viewProducts().subList(selected, selected + 1).get(0));
			} catch (Exception e) {
				setProduct(productService.viewProducts().subList(selected, count).get(0));
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

	public DataModel<Product> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Product> dataModel) {
		for (Product p : dataModel) {
			System.out.println(">>>>>>>>>>>" + p.getDesc());
		}
		this.dataModel = dataModel;
	}

	
	
	
	
	public String getPrice() {
		return price;
	}
	
	
	public void setStatus(boolean status){
		this.status = status;  
	}
	
	public String getStatus(){ 
		if(status)
		{
			
			return "Active";
		}
		else 
		{
			
			return "Discontinued";
		}
		}

	public void setPrice(String price) {
		product.setPrice(Double.parseDouble(price));
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String view() {

		return "productpage";
	}

	public String view(long id) {

		return "productpage";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public DataModel<Supplier> getDataSupplier(Product product) {
		dataSupplier = new ListDataModel<Supplier>(productService.getSuppliers(product));
		return dataSupplier;
	}

	public DataModel<Supplier> getDataSupplier() {
		return dataSupplier;
	}

	public void setDataSupplier(DataModel<Supplier> dataSupplier) {
		this.dataSupplier = dataSupplier;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
