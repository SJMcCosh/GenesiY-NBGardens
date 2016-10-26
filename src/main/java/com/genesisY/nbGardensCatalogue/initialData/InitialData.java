package com.genesisY.nbGardensCatalogue.initialData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Category;
import com.genesisY.nbGardensCatalogue.entities.CategoryToProductConn;
import com.genesisY.nbGardensCatalogue.entities.Customer;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrder;
import com.genesisY.nbGardensCatalogue.entities.CustomerOrderLine;
import com.genesisY.nbGardensCatalogue.entities.EmployeeLogin;
import com.genesisY.nbGardensCatalogue.entities.Product;
import com.genesisY.nbGardensCatalogue.entities.ProductTagLine;
import com.genesisY.nbGardensCatalogue.entities.ProductVariants;
import com.genesisY.nbGardensCatalogue.entities.PurchaseOrder;
import com.genesisY.nbGardensCatalogue.entities.PurchaseOrderLine;
import com.genesisY.nbGardensCatalogue.entities.Review;
import com.genesisY.nbGardensCatalogue.entities.Supplier;
import com.genesisY.nbGardensCatalogue.entities.Tag;

/**
 * Class that creates dummy data for testing purposes
 * 
 * @author Sam Precious
 *
 */
@Startup
@Singleton
public class InitialData {
	private ArrayList<Address> addressList = new ArrayList<Address>();
	private ArrayList<Category> categoryList = new ArrayList<Category>();
	private ArrayList<CategoryToProductConn> ctpcList = new ArrayList<CategoryToProductConn>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();
	private ArrayList<CustomerOrderLine> colList = new ArrayList<CustomerOrderLine>();
	private ArrayList<EmployeeLogin> employeeLoginList = new ArrayList<EmployeeLogin>();
	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<ProductTagLine> ptlList = new ArrayList<ProductTagLine>();
	private ArrayList<ProductVariants> productVariantsList = new ArrayList<ProductVariants>();
	private ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
	private ArrayList<PurchaseOrderLine> polList = new ArrayList<PurchaseOrderLine>();
	private ArrayList<Review> reviewList = new ArrayList<Review>();
	private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();

	@PostConstruct
	public void setupData() {
		Customer daveSmith = new Customer("Dave", "Smith", "dave@smith.com", "davesmith", "password1", "01478523698");
		Customer janeSmith = new Customer("Jane", "Smith", "jane@smith.com", "janesmith", "password2", "01478523698");
		Customer willSmith = new Customer("Will", "Smith", "will@smith.com", "willsmith", "password3", "01478523698");
		Tag t1 = new Tag("Gnome");
		Tag t2 = new Tag("Outdoor");
		Tag t3 = new Tag("Special");
		Tag t4 = new Tag("Cult");
		Tag t5 = new Tag("Tag5");
		
		List<Tag> list1 = new ArrayList<Tag>();
		list1.add(t1);
		list1.add(t3);
		list1.add(t5);
		List<Tag> list2 = new ArrayList<Tag>();
		list2.add(t2);
		list2.add(t4);
		list2.add(t1);
		List<Tag> list3 = new ArrayList<Tag>();
		list3.add(t3);
		list3.add(t4);
		list3.add(t1);
		addressList.add(new Address("d1addressLine1", "d1addressLine2", "d1addressLine3", "d1townCity", "d1county", "d1postcode", true, daveSmith));
		addressList.add(new Address("d2addressLine1", "d2addressLine2", "d2addressLine3", "d2townCity", "d2county", "d2postcode", false, daveSmith));
		addressList.add(new Address("d3addressLine1", "d3addressLine2", "d3addressLine3", "d3townCity", "d3county", "d3postcode", false, daveSmith));
		addressList.add(new Address("j1addressLine1", "j1addressLine2", "j1addressLine3", "j1townCity", "j1county", "j1postcode", false, janeSmith));
		addressList.add(new Address("j2addressLine1", "j2addressLine2", "j2addressLine3", "j2townCity", "j2county", "j2postcode", true, janeSmith));
		addressList.add(new Address("j3addressLine1", "j3addressLine2", "j3addressLine3", "j3townCity", "j3county", "j3postcode", false, janeSmith));
		addressList.add(new Address("w1addressLine1", "w1addressLine2", "w1addressLine3", "w1townCity", "w1county", "w1postcode", false, willSmith));
		addressList.add(new Address("w2addressLine1", "w2addressLine2", "w2addressLine3", "w2townCity", "w2county", "w2postcode", false, willSmith));
		addressList.add(new Address("w3addressLine1", "w3addressLine2", "w3addressLine3", "w3townCity", "w3county", "w3postcode", true, willSmith));
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		customerList.add(daveSmith); //Password = password1
		customerList.add(janeSmith);//Password = password2
		customerList.add(willSmith);//Password = password3
		colList.add(new CustomerOrderLine());
		productList.add(new Product("Gnome Trek", 4.5, "Gnome from the Star Trek franchise", "Dont care", 15.0, 150.50, list1));
		productList.add(new Product("Gnomeo and Gnomiet", 3.9, "Gnomes from the Shakespeare classic", "Dont care", 17.0, 97.99, list2));
		productList.add(new Product("Game of Gnomes", 4.2, "Gnome based on the GOT Series", "Dont care", 12.0, 111.29, list3));	
		categoryList.add(new Category("cat1"));
		categoryList.add(new Category("cat2"));
		categoryList.add(new Category("cat3"));
		categoryList.add(new Category("cat4"));
		categoryList.add(new Category("cat5"));
		categoryList.add(new Category("cat6"));
	}

	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	public void addAddress(Address address) {
		addressList.add(address);
	}

	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public void addCategory(Category category) {
		categoryList.add(category);
	}

	public ArrayList<CategoryToProductConn> getCtpcList() {
		return ctpcList;
	}

	public void setCtpcList(ArrayList<CategoryToProductConn> ctpcList) {
		this.ctpcList = ctpcList;
	}

	public void addCategoryToProduction(CategoryToProductConn ctp) {
		ctpcList.add(ctp);
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public ArrayList<CustomerOrder> getCustomerOrderList() {
		return customerOrderList;
	}

	public void setCustomerOrderList(ArrayList<CustomerOrder> customerOrderList) {
		this.customerOrderList = customerOrderList;
	}

	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderList.add(customerOrder);
	}

	public ArrayList<CustomerOrderLine> getColList() {
		return colList;
	}

	public void setColList(ArrayList<CustomerOrderLine> colList) {
		this.colList = colList;
	}

	public void addCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		colList.add(customerOrderLine);
	}

	public ArrayList<EmployeeLogin> getEmployeeLoginList() {
		return employeeLoginList;
	}

	public void setEmployeeLoginList(ArrayList<EmployeeLogin> employeeLoginList) {
		this.employeeLoginList = employeeLoginList;
	}

	public void addEmployeeLogin(EmployeeLogin employeeLogin) {
		employeeLoginList.add(employeeLogin);
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public ArrayList<ProductTagLine> getPtlList() {
		return ptlList;
	}

	public void setPtlList(ArrayList<ProductTagLine> ptlList) {
		this.ptlList = ptlList;
	}

	public void addProductTagLine(ProductTagLine ptl) {
		ptlList.add(ptl);
	}

	public ArrayList<ProductVariants> getProductVariantsList() {
		return productVariantsList;
	}

	public void setProductVariantsList(ArrayList<ProductVariants> productVariantsList) {
		this.productVariantsList = productVariantsList;
	}

	public void addProductVariants(ProductVariants productVariants) {
		productVariantsList.add(productVariants);
	}

	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	public void addProductOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderList.add(purchaseOrder);
	}

	public ArrayList<PurchaseOrderLine> getPolList() {
		return polList;
	}

	public void setPolList(ArrayList<PurchaseOrderLine> polList) {
		this.polList = polList;
	}

	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		polList.add(purchaseOrderLine);
	}

	public ArrayList<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public void addReview(Review review) {
		reviewList.add(review);
	}

	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public void addSupplier(Supplier supplier) {
		supplierList.add(supplier);
	}

}
