package com.publicissapient.day3;

public abstract class Contactable {
	
	private String email_Id;
	
	

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	
	public abstract void displayContactInfo();


}
