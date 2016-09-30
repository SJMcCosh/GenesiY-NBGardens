package com.genesisY.nbGardensCatalogue.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Tag outline
 * @author Brian McLaughlin
 */
@Entity
@Table (name = "category")
public class Tag 
{
	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "name", nullable = false, length = 225)
	@NotNull
	@Size (min = 2, max = 225)
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String vName)
	{
		this.name = vName;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
}
