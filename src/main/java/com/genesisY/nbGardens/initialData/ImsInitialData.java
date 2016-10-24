package com.genesisY.nbGardens.initialData;

import java.util.ArrayList;

import javax.annotation.*;
import javax.ejb.Startup;
import javax.inject.Singleton;

import com.genesisY.nbGardens.entities.Address;
import com.genesisY.nbGardens.entities.Product;
import com.genesisY.nbGardens.entities.Supplier;

@Startup
@Singleton
public class ImsInitialData {
	
	private ArrayList<Product> prodList = new ArrayList<Product>();
	private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
	
	
	
	@PostConstruct
	public void setupData()
	{
		prodList.add(new Product("Game of Gnomes", 4.5, "A GOT gnome", "No idea", 15.0));
		prodList.add(new Product("random gnome", 2.5, "lelelelel", "woah a second gnome", 10.0));
		Address address1 = new Address("32 Fine Strasse", "", "", "Berlin", "Germany", "54624");
		Supplier supplier1 = new Supplier("Gnomes4U", "05853123673", "gnomes4u@gnomes4u.com", address1);
		Address address2 = new Address("2546 New Road", "", "", "Paris", "France", "75003");
		Supplier supplier2 = new Supplier("Gnomeo's Gnomes", "12354234723", "gnomeo@gnomeosgnomes.com", address2);
		Address address3 = new Address("21 Gnome Street", "", "", "Saariselka", "Finland", "99830 Saariselka");
		Supplier supplier3 = new Supplier("Gnome Adventures", "34252824665", "gnomes@gnomeadventures.com", address3);
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		supplierList.add(supplier3);
	}
	
	
	public void setProdList(ArrayList<Product> v_prodList)
	{
		this.prodList = v_prodList;
	}
	
	
	public ArrayList<Product> getProdList()
	{
		return this.prodList;
	}
	
	public void setSupplierList(ArrayList<Supplier> supplierList)
	{
		this.supplierList = supplierList;
	}
	
	
	public ArrayList<Supplier> getSupplierList()
	{
		return this.supplierList;
	}
	
	
	public void addProduct(Product product)
	{
		this.prodList.add(product);
	}
	
	
	

}
