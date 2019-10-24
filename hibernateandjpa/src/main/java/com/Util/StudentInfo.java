package com.Util;

import javax.persistence.*;

@Entity
@Table
public class StudentInfo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String Name;
	private String Address;
	
	public StudentInfo()
	{
		super();
	}

	public StudentInfo(int id, String name, String address) 
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