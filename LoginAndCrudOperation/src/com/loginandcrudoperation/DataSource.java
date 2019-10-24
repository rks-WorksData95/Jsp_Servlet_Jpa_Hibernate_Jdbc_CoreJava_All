package com.loginandcrudoperation;

public class DataSource {
	
	private String FirstName,LastName,EmailId,Hobby,CityName;
	private int Id;
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	public String getEmailId() {
		return EmailId;
	}
	
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	
	public String getCityName() {
		return CityName;
	}
	
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getHobby() {
		return Hobby;
	}
	
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	
}
