package com.genesisY.nbGardens.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.genesisY.nbGardens.entities.Employee;

@SuppressWarnings("serial")
@Named("employee")
@SessionScoped
public class EmployeeController implements Serializable {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
