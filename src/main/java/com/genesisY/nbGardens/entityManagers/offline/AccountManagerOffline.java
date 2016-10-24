package com.genesisY.nbGardens.entityManagers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entityManagers.AccountManager;
import com.genesisY.nbGardens.initialData.ImsInitialData;

@Stateless
@Default
public class AccountManagerOffline implements AccountManager{
	
	@Inject
	private ImsInitialData ImsInitialData;

	@Override
	public void persistAccount(Employee customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistAccount(List<Employee> customerList) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Employee> customerList() {
		// TODO Auto-generated method stub
		return ImsInitialData.getEmployeeList();
	}
	@Override
	public Employee findByUsername(String username) {
		for (Employee e : ImsInitialData.getEmployeeList()){
			if (e.getUsername().equals(username)){
				return e;
			}
		}
		
		return null;
	}
	@Override
	public void updatePassword(String password, String username) {
		Employee e = findByUsername(username);
		e.setPassword(password);
		
	}
}
