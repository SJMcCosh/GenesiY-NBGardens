package com.genesisY.nbGardensIms.initialData;

import java.util.ArrayList;

import javax.annotation.*;

import com.genesisY.nbGardensCatalogue.entities.Product;

public class ImsInitialData {
	
	private ArrayList<Product> prodList = new ArrayList<Product>();
	
	
	
	@PostConstruct
	public void setupData()
	{
		prodList.add(new Product("Game of Gnomes", 4.5, "A GOT gnome", "No idea", 15.0));
		prodList.add(new Product("random gnome", 2.5, "lelelelel", "woah a second gnome", 10.0));		
	}
	
	
	public void setProdList(ArrayList<Product> v_prodList)
	{
		this.prodList = v_prodList;
	}
	
	
	public ArrayList<Product> getProdList()
	{
		return this.prodList;
	}
	
	
	public void addProduct(Product product)
	{
		this.prodList.add(product);
	}
	
	
	

}
