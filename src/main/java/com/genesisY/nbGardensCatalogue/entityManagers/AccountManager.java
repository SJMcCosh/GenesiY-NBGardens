package com.genesisY.nbGardensCatalogue.entityManagers;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardensCatalogue.entities.Employee;

public interface AccountManager {

	public void persistAccount(Employee customer);

	public void persistAccount(List<Employee> customerList);

	public ArrayList<Employee> customerList();

	public Employee findByUsername(String username);
}
