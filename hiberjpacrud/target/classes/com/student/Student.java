package com.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int Id;
	
	private String Name;
	private String Address;
	
	public Student()
	{
		super();
	}

	public Student(int id, String name, String address) 
	{
		super();
		Id = id;
		Name = name;
		Address = address;
	}

	public int getId()
	{
		return Id;
	}

	public void setId(int id) 
	{
		Id = id;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}

	public String getAddress()
	{
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}
	
}

