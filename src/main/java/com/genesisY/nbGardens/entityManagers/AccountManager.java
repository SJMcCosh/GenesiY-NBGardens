package com.genesisY.nbGardens.entityManagers;

import java.util.ArrayList;
import java.util.List;

import com.genesisY.nbGardens.entities.Employee;

public interface AccountManager {

	public void persistAccount(Employee customer);

	public void persistAccount(List<Employee> customerList);

	public ArrayList<Employee> customerList();

	public Employee findByUsername(String username);

	public void updatePassword(String password, String username);
}
