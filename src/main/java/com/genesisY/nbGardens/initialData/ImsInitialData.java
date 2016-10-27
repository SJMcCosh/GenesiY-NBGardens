package com.genesisY.nbGardens.initialData;

import java.util.ArrayList;

import javax.annotation.*;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;

@Startup
@Singleton
public class ImsInitialData {

	private ArrayList<Product> prodList = new ArrayList<Product>();
	private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@PostConstruct
	public void setupData() {
		Product product1 = new Product(1, "Game of Gnomes", "A GOT gnome", "img/gnome.jpg", 9.99, "Made in China", 12);
		Product product2 = new Product(2, "random gnome", "lelelelel", "img/gnome.jpg", 9.99, "Made in China", 0);
		Address address1 = new Address("32 Fine Strasse", "", "", "Berlin", "Germany", "54624");
		Address address2 = new Address("2546 New Road", "Lowry Quay", "Salford Quays", "Paris", "France", "75003");
		Address address3 = new Address("21 Gnome Street", "", "", "Saariselka", "Finland", "99830");
		Supplier supplier1 = new Supplier("Gnomes4U", "05853123673", "gnomes4u@gnomes4u.com", address1);
		Supplier supplier2 = new Supplier("Gnomeo's Gnomes", "12354234723", "gnomeo@gnomeosgnomes.com", address2);
		Supplier supplier3 = new Supplier("Gnome Adventures", "34252824665", "gnomes@gnomeadventures.com", address3);
		Employee employee1 = new Employee("AlStock", "Password1");
		prodList.add(product1);
		prodList.add(product2);
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
}
