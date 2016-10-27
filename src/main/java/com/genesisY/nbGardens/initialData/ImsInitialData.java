package com.genesisY.nbGardens.initialData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Category;
import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entities.EmployeeLogin;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.PurchaseOrder;
import com.genesisY.nbGardens.entities.Supplier;

@Startup
@Singleton
public class ImsInitialData {

	private ArrayList<Product> prodList = new ArrayList<Product>();
	private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();

	@PostConstruct
	public void setupData() {
		Category c1 = new Category("Pop culture");
		Category c2 = new Category("Seasonal");
		Category c3 = new Category("Classic");
		Category c4 = new Category("PFFFfff");
		Category c5 = new Category("What other kinds of gnomes are there!");
		Category c6 = new Category("Pop culture");
		
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
		
		
		Product product1 = new Product(1, "Game of Gnomes", "A GOT gnome", "img/gnome.jpg", 9.99, "Made in China", 12, cl1);
		Product product2 = new Product(2, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0, cl2);
		Product product3 = new Product(3, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0, cl3);
		Product product4 = new Product(4, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0, cl4);
		Product product5 = new Product(5, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0, cl5);
		Product product6 = new Product(6, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0, cl6);
		//Product product1 = new Product(1, "Game of Gnomes", 9.99, "A GOT gnome", "GnomesWarehouse", "img/gnome.jpg", "Made in China", 500, 4.7);
		//Product product2 = new Product(2, "random gnome", 8.59, "lelelelel", "GnomesWarehouse", "img/gnome.jpg", "Made in China", 180, 3.5);
		Address address1 = new Address("32 Fine Strasse", "", "", "Berlin", "Germany", "54624");
		Address address2 = new Address("2546 New Road", "Lowry Quay", "Salford Quays", "Paris", "France", "75003");
		Address address3 = new Address("21 Gnome Street", "", "", "Saariselka", "Finland", "99830");
		Supplier supplier1 = new Supplier("Gnomes4U", "05853123673", "gnomes4u@gnomes4u.com", address1);
		Supplier supplier2 = new Supplier("Gnomeo's Gnomes", "12354234723", "gnomeo@gnomeosgnomes.com", address2);
		Supplier supplier3 = new Supplier("Gnome Adventures", "34252824665", "gnomes@gnomeadventures.com", address3);
		Employee employee1 = new Employee("AlStock", "Password1");
	
		PurchaseOrder po1 = new PurchaseOrder(14503.99, supplier1, prodList); 
		PurchaseOrder po2 = new PurchaseOrder(146703.99, supplier2, prodList); 
		PurchaseOrder po3 = new PurchaseOrder(145303.99, supplier3, prodList); 
		PurchaseOrder po4 = new PurchaseOrder(14547.99, supplier1, prodList); 
		
		prodList.add(product1);
		prodList.add(product2);
		prodList.add(product3);
		prodList.add(product4);
		prodList.add(product5);
		prodList.add(product6);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
		employeeList.add(employee1);
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
}
