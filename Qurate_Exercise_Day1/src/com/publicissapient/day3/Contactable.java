package com.publicissapient.day3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;

public abstract class Contactable implements Serializable {

	private String email_Id;
	private String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]+$";
	private Pattern pattern = Pattern.compile(regex);
	private static Set<String> emailPool = new HashSet<>();

	public Contactable(String email) throws ContactException, EmailUniqueness {

		if (emailPool.add(email)) {

			Matcher matcher = pattern.matcher(email);
			if (!matcher.find()) {
				throw new ContactException("email passed does not matches the format - abc@xyz.pqr");
			} else {
				this.email_Id = email;
			}
		} else{throw new EmailUniqueness("Email is not unique !!");}
		}
	

	public Set<String> getEmailPool() {
		return emailPool;
	}

	public void setEmailPool(Set<String> emailPool) {
		this.emailPool = emailPool;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public abstract void displayContactInfo();

}
