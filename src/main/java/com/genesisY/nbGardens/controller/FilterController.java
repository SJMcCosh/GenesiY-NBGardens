package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

@Named ("filter")
@SessionScoped 

public class FilterController implements Serializable{
	
	
	public String filter(String filter) {
	
		//TODO link service layer
		
		return "subCategory";

	}

}
