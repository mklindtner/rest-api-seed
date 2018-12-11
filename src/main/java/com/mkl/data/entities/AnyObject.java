package com.mkl.data.entities;

import javax.persistence.*;

@Entity
public class AnyObject
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nameString;

	public AnyObject() {}

	public AnyObject(String nameString)
	{
		this.nameString = nameString;
	}

	public int getId()
	{
		return this.id;
	}

	public String getNameString()
	{
		return this.nameString;
	}
}
