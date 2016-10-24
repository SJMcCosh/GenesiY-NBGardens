/**
 * CustomerManagerOffline class
 * Implements CustomerRepository interface
 * @author Brian McLaughlin
 */

package com.genesisY.nbGardens.entityManagers.offline;

import javax.ejb.Stateless;

import com.genesisY.nbGardens.entities.Employee;
import com.genesisY.nbGardens.entityManagers.EmployeeManager;

@Stateless
public class EmployeeManagerOffline implements EmployeeManager
{
	//Read
	public void readEmployeeDetails(Employee c)
	{
		
	}
}
