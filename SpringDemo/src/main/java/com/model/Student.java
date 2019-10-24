package com.model;

public class Student
{
	private String studentName;
	private String Address;
	private int rollNo;
	
	
	
	public Student(int rollNo) 
	{
		super();
		this.rollNo = rollNo;
	}

	public Student(String address) 
	{
		super();
		Address = address;
	}

	
	
	public Student(String studentName, int rollNo) 
	{
		super();
		this.studentName = studentName;
		this.rollNo = rollNo;
	}

	public Student(String studentName, String address, int rollNo) 
	{
		super();
		this.studentName = studentName;
		Address = address;
		this.rollNo = rollNo;
	}

	public int getRollNo() 
	{
		return rollNo;
	}

	public void setRollNo(int rollNo) 
	{
		this.rollNo = rollNo;
	}

	public String getStudentName() 
	{
		return studentName;
	}

	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}

	public String getAddress() 
	{
		return Address;
	}

	public void setAddress(String address) 
	{
		Address = address;
	}
	
	public void displayStudentInfo()
	{
		System.out.println("Roll No : "+rollNo);
		System.out.println("Name : "+studentName);
		System.out.println("Address : "+Address);
	}
}
