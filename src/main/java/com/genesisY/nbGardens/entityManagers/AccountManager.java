package com.genesisY.nbGardens.entityManagers;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardens.entities.Employee;

public interface AccountManager {

	public void persistAccount(Employee employee);

	public void persistAccount(List<Employee> employeeList);

	public ArrayList<Employee> employeeList();

	public Employee findByUsername(String username);
}
