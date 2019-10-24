package com.model;

public class A
{
	B b;
	
	public A()
	{
		super();
		System.out.println("A Is Created.");
	}
	
	public B getB()
	{
		return b;
	}

	public void setB(B b) 
	{
		this.b = b;
	}
	
	void print()
	{
		System.out.println("Hello A.");
	}
	
	public void display()
	{
		print();
		b.print();
	}
}
