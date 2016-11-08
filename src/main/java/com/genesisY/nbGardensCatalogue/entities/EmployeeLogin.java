package com.genesisY.nbGardensCatalogue.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Outline for the Employee login
 * 
 * @author Sam Precious
 *
 */

@Entity
@Table(name = "employee_login")
public class EmployeeLogin {

	@Id
	@Column(name = "login", nullable = false, length = 20)
	@NotNull
	@Size(min = 2, max = 20)
	private String login;

	@Column(name = "password", nullable = false, length = 64)
	@NotNull
	@Size(min = 64)
	private String password;

	public EmployeeLogin() {

	}

	public EmployeeLogin(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
