package com.genesisY.nbGardens.initialData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entities.Notification;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entities.StockAlert;
import com.genesisY.nbGardens.entities.Supplier;

@Startup
@Singleton
public class ImsInitialData {

	private ArrayList<Product> prodList = new ArrayList<Product>();
	private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
	private ArrayList<Product> pOprodList = new ArrayList<Product>(); 
	private ArrayList<Category> catList = new ArrayList<Category>();
	private ArrayList<Notification> notList = new ArrayList<Notification>();
	private ArrayList<StockAlert> saList = new ArrayList<StockAlert>();
	
	private ArrayList<Product> selectedProdList = new ArrayList<Product>();

	@PostConstruct
	public void setupData() {


		Category c1 = new Category("Seasonal");
		Category c2 = new Category("Classic");
		Category c3 = new Category("Musical");
		Category c4 = new Category("Television");
		Category c5 = new Category("Movies");
		Category c6 = new Category("Video Games");
		
		List<Category> cl1 = new ArrayList<Category>();
		cl1.add(c1);
		cl1.add(c3);
		List<Category> cl2 = new ArrayList<Category>();
		cl2.add(c2);
		cl2.add(c4);
		List<Category> cl3 = new ArrayList<Category>();
		cl3.add(c6);
		cl3.add(c5);
		List<Category> cl4 = new ArrayList<Category>();
		cl4.add(c2);
		cl4.add(c3);
		List<Category> cl5 = new ArrayList<Category>();
		cl5.add(c1);
		cl5.add(c4);
		List<Category> cl6 = new ArrayList<Category>();
		cl6.add(c6);
		cl6.add(c3);

		catList.add(c1);
		catList.add(c2);
		catList.add(c3);
		catList.add(c4);
		catList.add(c5);
		catList.add(c6);
		
		Product product1 = new Product(1, "Game of Gnomes", "A GOT gnome", "img/gnomeGOT.jpg", 9.99, "Made in Westeros", 12, 20, cl1, true, true);
		Product product2 = new Product(2, "UK Gnome", "Made in Blighty", "img/gnome-06.jpg", 15.29, "Made in the UK", 52, 40, cl2, true, true);
		Product product3 = new Product(3, "EU Gnome", "With love from Brussels", "img/gnome-07.jpg", 6.50, "Made in the EU", 121, 35, cl3, true, true);
		Product product4 = new Product(4, "big gnome", "B.I.G, big!", "img/gnomeGOT.jpg", 12.99, "Made in the UK", 94, 15, cl4, true, true);
		Product product5 = new Product(5, "small gnome", "Rather small gnome", "img/gnome-06.jpg", 2.50, "Made in Taiwan", 87, 50, cl5, true, true);
		Product product6 = new Product(6, "LED Glowing gnome", "Useful as a Night light", "img/gnome-07.jpg", 4.99, "Made in Japan", 20, 30, cl6, true, true);
		Product product7 = new Product(7, "Trump Gnome", "Make your Garden Great Again", "img/gnomeTrump.jpg", 370.00, "Made in China", 1000000, 100, cl1, true, true);


		List<Product> products1 = new ArrayList<Product>();
		List<Product> products2 = new ArrayList<Product>();
		List<Product> products3= new ArrayList<Product>();
		
		products1.add(product1);
		products1.add(product2);
		products1.add(product4);
		products1.add(product6);
		products1.add(product7);
		products2.add(product2);
		products2.add(product4);
		products2.add(product5);
		products2.add(product7);
		products3.add(product3);
		products3.add(product1);
		products3.add(product5);
		products3.add(product6);
		products3.add(product4);
		products3.add(product7);

		Address address1 = new Address("32 Fine Strasse", "", "", "Berlin", "Germany", "54624");
		Address address2 = new Address("2546 New Road", "Lowry Quay", "Salford Quays", "Paris", "France", "75003");
		Address address3 = new Address("21 Gnome Street", "", "", "Saariselka", "Finland", "99830");
		
		Supplier supplier1 = new Supplier("Gnomes4U", "05853123673", "gnomes4u@gnomes4u.com", address1, products1);
		Supplier supplier2 = new Supplier("Gnomeo's Gnomes", "12354234723", "gnomeo@gnomeosgnomes.com", address2, products2);
		Supplier supplier3 = new Supplier("Gnome Adventures", "34252824665", "gnomes@gnomeadventures.com", address3, products3);
		
		Employee AlStock = new Employee("AlStock", "Password1");
	
		PurchaseOrder po1 = new PurchaseOrder(14503.99, supplier1, products1); 
		PurchaseOrder po2 = new PurchaseOrder(146703.99, supplier2, products2); 
		PurchaseOrder po3 = new PurchaseOrder(145303.99, supplier3, products3); 
		PurchaseOrder po4 = new PurchaseOrder(14547.99, supplier1, products1); 
		
		
		prodList.add(product1);
		prodList.add(product2);
		prodList.add(product3);
		prodList.add(product4);
		prodList.add(product5);
		prodList.add(product6);
		prodList.add(product7);
		
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		
		employeeList.add(AlStock); //Password = Password1
		
		purchaseOrderList.add(po1);
		purchaseOrderList.add(po2);
		purchaseOrderList.add(po3);
		purchaseOrderList.add(po4);
		
		Notification n1 = new Notification(1, "Purchase Order #123456 approved", "03/11/2016");
		Notification n2 = new Notification(1, "Purchase Order #123457 rejected", "02/11/2016");
		Notification n3 = new Notification(1, "Purchase Order #123458 delivered", "01/11/2016");
		
		notList.add(n1);
		notList.add(n2);
		notList.add(n3);
		
		StockAlert sa1 = new StockAlert(1, "03/11/2016", "Game of Gnomes low stock", product1);
		StockAlert sa2 = new StockAlert(2, "02/11/2016", "Random gnome low stock", product2);
		StockAlert sa3 = new StockAlert(3, "02/11/2016", "Other Gnome low stock", product3);
		StockAlert sa4 = new StockAlert(4, "02/11/2016", "Big Gnome low stock", product4);
		StockAlert sa5 = new StockAlert(5, "02/11/2016", "Trump Gnome low stock", product7);
		
		
		saList.add(sa1);
		saList.add(sa2);
		saList.add(sa3);
		saList.add(sa4);
		saList.add(sa5);
	}

	public ArrayList<StockAlert> getSaList() {
		System.out.println(">>>>>Initial Data");
		return saList;
	}

	public void setSaList(ArrayList<StockAlert> saList) {
		this.saList = saList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public ArrayList<Employee> getEmployeeList() {
		ArrayList<Employee> employees = this.employeeList;
		return employees;
	}

	public void setProdList(ArrayList<Product> v_prodList) {
		this.prodList = v_prodList;
	}

	public ArrayList<Product> getProdList() {
		ArrayList<Product> products = this.prodList;
		return products;
	}

	public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}

	public ArrayList<Supplier> getSupplierList() {
		ArrayList<Supplier> suppliers = this.supplierList;
		System.out.println(suppliers);
		return suppliers;
		
	}
	public void addSupplier(Supplier supplier) {
		this.supplierList.add(supplier);
	}

	public void addProduct(Product product) {
		this.prodList.add(product);
	}
	
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrderList.add(purchaseOrder);
	}
	
	public ArrayList<Category> getCatList() {
		return catList;
	}
	
	public void setCatList(ArrayList<Category> catList) {
		this.catList = catList;
	}

	public ArrayList<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}

	public void setPurchaseOrderList(ArrayList<PurchaseOrder> purchaseOrderList) {
		this.purchaseOrderList = purchaseOrderList;
	}

	public ArrayList<Product> getpOprodList() {
		return pOprodList;
	}

	public void setpOprodList(ArrayList<Product> pOprodList) {
		this.pOprodList = pOprodList;
	}

	public ArrayList<Notification> getNotList() {
		return notList;
	}

	public void setNotList(ArrayList<Notification> notList) {
		this.notList = notList;
	}

	public List<Product> getSelectedProduct(int id) {
		for(Product p : prodList)
		{
			if(id == p.getProductID())
			{
				selectedProdList.add(p);
			}
		}
		return selectedProdList;
	}
}
