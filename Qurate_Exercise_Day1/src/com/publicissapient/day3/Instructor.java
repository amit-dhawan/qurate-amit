package com.publicissapient.day3;

import com.publicissapient.day2.Person;

public class Instructor extends Person {

	private String subject;
	private int rating;

	public Instructor(String name, int age, String gender, String subject, int rating) {
		super(name, age, gender);
		this.setSubject(subject);
		this.setRating(rating);
	}

	public String getSubject() {
		return subject;
	}

	public int getRating() {
		return rating;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRatingComments(int rating) {
		String comment = null;
		if (rating < 5) {
			comment = "Poor";
		} else if (rating >= 5 && rating <= 7) {
			comment = "Average";
		} else if (rating > 7 && rating <= 9) {
			comment = "Good";
		} else if (rating == 10) {
			comment = "Expert";
		} else {
			comment = "Invalid Rating";
		}
		return comment;
	}

	@Override
	public void displayInfo() {
		greet();
		System.out.println("Instructor[name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender()
				+ ", Subject Name=" + getSubject() + ", Rating=" + getRating() + ", Rating Comment="
				+ getRatingComments(getRating()) + "]"  + ", person counter is: " +Person.getPersonCounter());
	}
	
	@Override
	public void greet() {
		System.out.println("Hello Instructor");
	}

} // class ends
