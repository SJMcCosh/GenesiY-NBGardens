	/**
	 * Interface to be implemented in offline + online CustomerManager classes
	 * @author Brian McLaughlin
	 */

	package com.genesisY.nbGardens.entityManagers;

	import com.genesisY.nbGardens.entities.Employee;

	public interface EmployeeManager 
	{
		//Read
		public void readEmployeeDetails(Employee c);
		
	}