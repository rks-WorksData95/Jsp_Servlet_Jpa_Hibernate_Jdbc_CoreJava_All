package com.demo;
import java.io.Serializable;
public class infoBean implements Serializable{
	
	private int id;
	private String name;
	
	public infoBean() {
		this.id = 0;
		this.name = "Ram";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
