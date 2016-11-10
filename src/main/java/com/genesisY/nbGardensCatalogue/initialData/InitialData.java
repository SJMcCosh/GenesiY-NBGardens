package com.genesisY.nbGardensCatalogue.initialData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardensCatalogue.entities.Address;
import com.genesisY.nbGardensCatalogue.entities.Basket;
import com.genesisY.nbGardensCatalogue.entities.BasketItem;
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
	private ArrayList<Tag> tagList = new ArrayList<Tag>();
	private ArrayList<BasketItem> basketItems = new ArrayList<BasketItem>();

	@PostConstruct
	public void setupData() {

		//Tags
		Tag t1 = new Tag("Gnome");
		Tag t2 = new Tag("Outdoor");
		Tag t3 = new Tag("Special");
		Tag t4 = new Tag("Cult");
		Tag t5 = new Tag("Romantic");
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

		//Reviews
		Review r1 = new Review(3, "Its a good gnome");
		Review r2 = new Review(4, "Its a really good gnome");
		Review r3 = new Review(2, "Its a nice gnome");
		Review r4 = new Review(5, "Its a fantastic gnome");
		Review r5 = new Review(1, "It was an adequate gnome");
		Review r6 = new Review(5, "Its a fantastic gnome");
		Review r7 = new Review(2, "Its a nice gnome");
		Review r8 = new Review(4, "Its a really good gnome");
		Review r9 = new Review(3, "Its a good gnome");
		Review r10 = new Review(1, "It was an adequate gnome");

		reviewList.add(r1);
		reviewList.add(r2);
		reviewList.add(r3);
		reviewList.add(r4);
		reviewList.add(r5);
		reviewList.add(r6);
		reviewList.add(r7);
		reviewList.add(r8);
		reviewList.add(r9);
		reviewList.add(r10);

		//Categories
		categoryList.add(new Category("All", "Gnomes", "img/easterGnome.png"));
		categoryList.add(new Category("Popular Culture", "Gnomes", "img/olympicGnomes.jpg"));
		categoryList.add(new Category("Romance", "Gnomes", "img/valentineGnome.jpg"));
		categoryList.add(new Category("Sci-Fi", "Gnomes", "img/starTrekGnome.jpg"));
		categoryList.add(new Category("Fantasy", "Gnomes", "img/zombieGnome.jpeg"));
		categoryList.add(new Category("All", "Outdoor Living", "img/newJobGnome.jpg"));
		categoryList.add(new Category("All", "Garden Tools", "img/stPatrickGnome.jpg"));
		//Outdoor Living		
		categoryList.add(new Category("All", "Outdoor Buildings", "img/xmasGnome.jpg"));
		categoryList.add(new Category("Seating", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Outdoor Structures", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Gardening Tools", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Storage Solutions", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Decking", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Pressure Washers", "Outdoor Living", "img/royalGnome.jpg"));
		categoryList.add(new Category("Power Tools", "Outdoor Living", "img/royalGnome.jpg"));
		
		
		categoryList.add(new Category("Lawncare", "Garden Tools", "img/summerGnome.jpg"));
		categoryList.add(new Category("Digging", "Garden Tools", "img/weddingGnome.jpg"));
		categoryList.add(new Category("Sheds", "Outdoor Buildings", "img/easterGnome.png"));
		List<Category> c1 = new ArrayList<Category>();
		List<Category> c2 = new ArrayList<Category>();
		List<Category> c3 = new ArrayList<Category>();
		c1.add(new Category("All", "Gnomes", "img/easterGnome.png"));
		c1.add(new Category("Popular Culture", "Gnomes", "img/olympicGnomes.jpg"));
		c1.add(new Category("Sci-Fi", "Gnomes", "img/starTrekGnome.jpg"));
		c2.add(new Category("All", "Gnomes", "img/easterGnome.png"));
		c2.add(new Category("Romance", "Gnomes", "img/valentineGnome.jpg"));
		c3.add(new Category("All", "Gnomes", "img/easterGnome.png"));
		c3.add(new Category("Popular Culture", "Gnomes", "img/olympicGnomes.jpg"));
		c3.add(new Category("Fantasy", "Gnomes", "img/zombieGnome.jpeg"));

		//Products
		productList.add(new Product(1, "Chelsea FC Gnome", 4.5, "Gnome wearing the glorious Chelsea FC shirt", "Small", 
				3.0, 25.00, list1, "img/chelseaGnome.jpg", reviewList, c1, 25));
		productList.add(new Product(2, "Mr and Mrs Gnome", 3.9, "A pair of gnomes who are clearly blinded by love", "Large",
				13.0, 12.50, list2, "img/coupleGnome.jpg", reviewList, c2, 10));
		productList.add(new Product(3, "Mickey and Minnie Mouse Gnome", 4.2, "The world's most favourite couple", "Large", 13.0,
				30.00, list3, "img/disneyGnome.jpg", reviewList, c3, 5));
		productList.add(new Product(4, "Happy Gnome", 4.5, "Welcoming gnome, good for the doorstep", "Medium", 7.0,
				13.50, list1, "img/happyGnome.jpg", reviewList, c1, 15));
		productList.add(new Product(5, "Arsenal FC Gnome", 3.9, "Gnome wearing the glorious Arsenal FC Shirt", "Small",
				3.0, 25.00, list2, "img/footballGnome.jpg", reviewList, c2, 60));
		productList.add(new Product(6, "Grumpy Gnome", 4.2, "Welcoming gnome, good for the doorstep", "Medium", 7.0,
				13.50, list3, "img/grumpyGnome.jpg", reviewList, c3, 80));
		productList.add(new Product(7, "Ninja Gnome", 4.5, "Don't mess with this gnome!", "Small", 3.0,
				17.50, list1, "img/ninjaGnome.jpg", reviewList, c1, 40));
		productList.add(new Product(8, "Pulp Fiction Gnome", 3.9, "Don't mess with this gnome!", "Medium",
				7.0, 17.50, list2, "img/pulpFictionGnome.jpg", reviewList, c2, 95));
		productList.add(new Product(9, "Rebel Gnome", 4.2, "The thug life chose him", "Large", 13.0,
				13.50, list3, "img/rebelGnome.jpg", reviewList, c3, 40));
		productList.add(new Product(10, "Santa Gnome", 4.5, "Santa's on his way!", "Medium", 7.0,
				150.50, list1, "img/santaGnome.jpg", reviewList, c1, 0));
		productList.add(new Product(11, "Bouncer Gnome", 3.9, "There's no getting around this gnome", "Small",
				3.0, 19.99, list2, "img/securityGnome.jpg", reviewList, c2, 5));
		productList.add(new Product(12, "Star Wars Gnome", 4.2, "This gnome is taking you back in time", "Small", 3.0,
				34.99, list3, "img/starWarsGnome.jpg", reviewList, c3, 10));
		productList.add(new Product(13, "St Patricks Gnome", 4.5, "This gnome is green and full of luck", "Medium", 7.0,
				15.00, list1, "img/paddyGnome.jpg", reviewList, c1, 20));
		productList.add(new Product(14, "Hey There Trio", 3.9, "Welcoming gnomes, good for the doorstep", "Large",
				13.0, 19.99, list2, "img/welcomeGnome.jpg", reviewList, c2, 25));
		productList.add(new Product(15, "Wizard Gnome", 4.2, "Careful, this gnome casts spells!", "Small", 3.0,
				11.99, list3, "img/wizardGnome.jpg", reviewList, c3, 35));
		productList.add(new Product(16, "Murder Suspect Gnome", 4.5, "This gnome was born to be violent", "Large", 13.0,
				17.99, list1, "img/zombie_gnome_fishing.jpg", reviewList, c1, 60));
		productList.add(new Product(17, "Grattan Bench", 3.9, "Lovely bench suitable for the outdoors", "Large",
				26.0, 44.99, list2, "img/Bench.jpg", reviewList, c2, 75));
		productList.add(new Product(18, "Spade", 4.2, "Garden spade", "Large", 17.0,
				11.00, list3, "img/Spade.jpg", reviewList, c3, 70));
		productList.add(new Product(19, "Garden Playhouse", 4.5, "Wooden playhouse, perfect for a medium to large sized garden", 
				"Large", 25.0, 275.00, list1, "img/Playhouse.jpg", reviewList, c1, 45));
		productList.add(new Product(20, "BBQ", 3.9, "BBQ grill (person not included)", "Large",
				20.0, 99.99, list2, "img/BBQ.jpg", reviewList, c2, 40));
		
		//Customer orders
		List<Product> cop1 = new ArrayList<Product>();
		cop1.add(productList.get(0));
		cop1.add(productList.get(4));
		cop1.add(productList.get(5));
		List<Product> cop2 = new ArrayList<Product>();
		cop2.add(productList.get(1));
		cop2.add(productList.get(2));
		cop2.add(productList.get(6));
		List<Product> cop3 = new ArrayList<Product>();
		cop3.add(productList.get(5));
		cop3.add(productList.get(9));
		cop3.add(productList.get(9));
		
		CustomerOrder co1 = new CustomerOrder(cop1);
		CustomerOrder co2 = new CustomerOrder(cop2);
		CustomerOrder co3 = new CustomerOrder(cop3);
		
		customerOrderList.add(co1);
		customerOrderList.add(co2);
		customerOrderList.add(co3);

		//Customers
		Customer daveSmith = new Customer("Dave", "Smith", "dave@smith.com", "davesmith",
				"5767ae8832684b68fb15def789461d2ce13236f432961154004e19da68481385", "01478523698", customerOrderList);
		Customer janeSmith = new Customer("Jane", "Smith", "jane@smith.com", "janesmith",
				"f4db65702a99e3121c736d40ac2089dcb2c2df87c043521c7aafd53e0974520a", "01478523698", customerOrderList);
		Customer willSmith = new Customer("Will", "Smith", "will@smith.com", "willsmith",
				"833d73142a8b84c001442195843bae2187b83c4ae86cd300d3c1587f4dec8be0", "01478523698", customerOrderList);

		//Addresses
		addressList.add(new Address(1, "d1addressLine1", "d1addressLine2", "d1addressLine3", "d1townCity", "d1county",
				"d1postcode", true, true, daveSmith));
		addressList.add(new Address(2, "d2addressLine1", "d2addressLine2", "d2addressLine3", "d2townCity", "d2county",
				"d2postcode", false, true, daveSmith));
		addressList.add(new Address(3, "d3addressLine1", "d3addressLine2", "d3addressLine3", "d3townCity", "d3county",
				"d3postcode", false, true, daveSmith));
		addressList.add(new Address(4, "j1addressLine1", "j1addressLine2", "j1addressLine3", "j1townCity", "j1county",
				"j1postcode", false, true, janeSmith));
		addressList.add(new Address(5, "j2addressLine1", "j2addressLine2", "j2addressLine3", "j2townCity", "j2county",
				"j2postcode", true, true, janeSmith));
		addressList.add(new Address(6, "j3addressLine1", "j3addressLine2", "j3addressLine3", "j3townCity", "j3county",
				"j3postcode", false, true, janeSmith));
		addressList.add(new Address(7, "w1addressLine1", "w1addressLine2", "w1addressLine3", "w1townCity", "w1county",
				"w1postcode", false, true, willSmith));
		addressList.add(new Address(8, "w2addressLine1", "w2addressLine2", "w2addressLine3", "w2townCity", "w2county",
				"w2postcode", false, true, willSmith));
		addressList.add(new Address(9, "w3addressLine1", "w3addressLine2", "w3addressLine3", "w3townCity", "w3county",
				"w3postcode", true, true, willSmith));
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		ctpcList.add(new CategoryToProductConn());
		customerList.add(daveSmith); // Password = password1
		customerList.add(janeSmith);// Password = password2
		customerList.add(willSmith);// Password = password3

		/*
		 * // Basket List Product prod1 = new Product("Gnomeo and Gnomiet", 3.9,
		 * "Gnomes from the Shakespeare classic", "Dont care", 17.0, 97.99,
		 * list2, "img/zombiefeast.jpg"); BasketItem basketItem1 = new
		 * BasketItem(prod1, 1); basketItems.add(basketItem1);
		 * 
		 * Product prod2 = new Product("Game of Gnomes", 4.2,
		 * "Gnome based on the GOT Series", "Dont care", 12.0, 111.29, list3,
		 * "img/IndexImages/gnome_new.jpg"); BasketItem basketItem2 = new
		 * BasketItem(prod2, 3); basketItems.add(basketItem2);
		 * 
		 * Product prod3 = new Product("Gnome Trek", 4.5,
		 * "Gnome from the Star Trek franchise", "Dont care", 15.0, 150.50,
		 * list1, "img/zombie_gnome_fishing.jpg"); BasketItem basketItem3 = new
		 * BasketItem(prod3, 2); basketItems.add(basketItem3);
		 */
		// basketList.add(new Basket(3, "Gnome 3", "This is a test gnome 3", 20,
		// 100.00));
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

	public ArrayList<BasketItem> getBasketList() {
		return basketItems;
	}

	public void addBasketItem(BasketItem basketItem) {
		basketItems.add(basketItem);
	}

	// public void setBasketList(ArrayList<Basket> basketList) {
	// this.basketList = basketList;
	// }

}
