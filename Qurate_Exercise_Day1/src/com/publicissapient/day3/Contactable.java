package com.publicissapient.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.publicissapient.day5.exceptions.ContactException;

public abstract class Contactable {

	private String email_Id;
	private String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]+$";
	private Pattern pattern = Pattern.compile(regex);

	public Contactable(String email) throws ContactException {

		Matcher matcher = pattern.matcher(email);

		if (!matcher.find()) {

			throw new ContactException("email passed does not matches the format - abc@xyz.pqr" );
			
		} else {
			this.email_Id = email;
		}

	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public abstract void displayContactInfo();

}
