package com.loginandcrudoperation;

import java.util.ArrayList;

public class DataSourceList {

	public static ArrayList<DataSource> RegisterData=new ArrayList<DataSource>();
	static int id=1;
	
	public void insertData(DataSource ds)
	{
		ds.setId(id);
		RegisterData.add(ds);
		id++;
	}

	public void updateData(DataSource ds)
	{
		for(DataSource ds1:RegisterData)
		{
			if(ds1.getId()==ds.getId())
			{
				RegisterData.set(RegisterData.indexOf(ds1), ds);
			}
		}
	}
	
	public  void deleteUser(int id)
	{
		for(int i=0;i<RegisterData.size();i++)
		{
			if(RegisterData.get(i).getId()==id)
			{
				RegisterData.remove(i);
			}
		}
	}
}
