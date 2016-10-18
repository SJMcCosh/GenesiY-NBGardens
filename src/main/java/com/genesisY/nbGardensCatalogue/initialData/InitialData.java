package com.genesisY.nbGardensCatalogue.initialData;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ejb.Startup;

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
 * @author Sam Precious
 *
 */
@Startup
@Singleton
public class InitialData{
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
	private ArrayList<Tag> tagList = new ArrayList<Tag>();
	
	@PostConstruct
	public void setupData(){
		addressList.add(new Address());
		addressList.add(new Address());
		addressList.add(new Address());
		categoryList.add(new Category());
		categoryList.add(new Category());
		categoryList.add(new Category());
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		customerList.add(new Customer("Dave", "Smith", "dave@smith.com", "davesmith", "1234", "01478523698"));
		customerList.add(new Customer("Jane", "Smith", "jane@smith.com", "janesmith", "1234", "01478523698"));
		customerList.add(new Customer("Will", "Smith", "will@smith.com", "willsmith", "1234", "01478523698"));
		colList.add(new CustomerOrderLine());
		productList.add(new Product("Game of Gnomes", 4.5, "Gnome based on the GOT Seriese", "Dont care", 15.0, 150.50));
		productList.add(new Product("Game of Gnomes", 4.5, "Gnome based on the GOT Seriese", "Dont care", 15.0, 150.50));
		productList.add(new Product("Game of Gnomes", 4.5, "Gnome based on the GOT Seriese", "Dont care", 15.0, 150.50));
		tagList.add(new Tag("Tag1"));
		tagList.add(new Tag("Tag2"));
		tagList.add(new Tag("Tag3"));
		tagList.add(new Tag("Tag4"));
		tagList.add(new Tag("Tag5"));
	}
	
	public ArrayList<Address> getAddressList() {
		return addressList;
	}
	
	
	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}
	
	public void addAddress(Address address){
		addressList.add(address);
	}
	
	
	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}
	
	
	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	public void addCategory(Category category){
		categoryList.add(category);
	}
	
	
	public ArrayList<CategoryToProductConn> getCtpcList() {
		return ctpcList;
	}
	
	
	public void setCtpcList(ArrayList<CategoryToProductConn> ctpcList) {
		this.ctpcList = ctpcList;
	}
	
	public void addCategoryToProduction(CategoryToProductConn ctp){
		ctpcList.add(ctp);
	}
	
	
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
	
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	public void addCustomer(Customer customer){
		customerList.add(customer);
	}
	
	public ArrayList<CustomerOrder> getCustomerOrderList() {
		return customerOrderList;
	}
	
	
	public void setCustomerOrderList(ArrayList<CustomerOrder> customerOrderList) {
		this.customerOrderList = customerOrderList;
	}
	
	public void addCustomerOrder(CustomerOrder customerOrder){
		customerOrderList.add(customerOrder);
	}
	
	public ArrayList<CustomerOrderLine> getColList() {
		return colList;
	}
	
	
	public void setColList(ArrayList<CustomerOrderLine> colList) {
		this.colList = colList;
	}
	
	public void addCustomerOrderLine(CustomerOrderLine customerOrderLine){
		colList.add(customerOrderLine);
	}
	
	public ArrayList<EmployeeLogin> getEmployeeLoginList() {
		return employeeLoginList;
	}
	
	
	public void setEmployeeLoginList(ArrayList<EmployeeLogin> employeeLoginList) {
		this.employeeLoginList = employeeLoginList;
	}
	
	public void addEmployeeLogin(EmployeeLogin employeeLogin){
		employeeLoginList.add(employeeLogin);
	}
	
	
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	public void addProduct(Product product){
		productList.add(product);
	}
	
	public ArrayList<ProductTagLine> getPtlList() {
		return ptlList;
	}
	
	
	public void setPtlList(ArrayList<ProductTagLine> ptlList) {
		this.ptlList = ptlList;
	}
	
	public void addProductTagLine(ProductTagLine ptl){
		ptlList.add(ptl);
	}
	
	public ArrayList<ProductVariants> getProductVariantsList() {
		return productVariantsList;
	}
	
	
	public void setProductVariantsList(ArrayList<ProductVariants> productVariantsList) {
		this.productVariantsList = productVariantsList;
	}
	
	public void addProductVariants(ProductVariants productVariants){
		productVariantsList.add(productVariants);
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}
	
	
	public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}
	
	public void addProductOrder(PurchaseOrder purchaseOrder){
		purchaseOrderList.add(purchaseOrder);
	}
	
	public ArrayList<PurchaseOrderLine> getPolList() {
		return polList;
	}
	
	
	public void setPolList(ArrayList<PurchaseOrderLine> polList) {
		this.polList = polList;
	}
	
	public void addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine){
		polList.add(purchaseOrderLine);
	}
	
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}
	
	
	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
	public void addReview(Review review){
		reviewList.add(review);
	}
	
	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}
	
	
	public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	
	public void addSupplier(Supplier supplier){
		supplierList.add(supplier);
	}
	
	public ArrayList<Tag> getTagList() {
		return tagList;
	}
	
	
	public void setTagList(ArrayList<Tag> tagList) {
		this.tagList = tagList;
	}
	
	public void addTag(Tag tag){
		tagList.add(tag);
	}
	
}
