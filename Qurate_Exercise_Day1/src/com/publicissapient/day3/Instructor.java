package com.publicissapient.day3;

import com.publicissapient.day2.Person;

public class Instructor extends Person {

	private String subject;
	private Integer rating;
	private Feedback[] arrayOfFeedback;

	public Feedback[] getArrayOfFeedback() {
		return arrayOfFeedback;
	}

	public void setArrayOfFeedback(Feedback[] arrayOfFeedback) {
		this.arrayOfFeedback = arrayOfFeedback;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Instructor(String name, int age, String gender, String subject) {
		super(name, age, gender);
		this.setSubject(subject);
	}

	public Instructor() {

	}

	public String getSubject() {
		return subject;
	}

	public Integer getRating() {
		return rating;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRatingComments(Integer rating) {
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
		calculateEffectiveRating();
		System.out.println("Instructor[name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender()
				+ ", Subject Name=" + getSubject() + ", Rating=" + getRating() + ", Rating Comment="
				+ getRatingComments(getRating()) + "]" + ", person counter is: " + Person.getPersonCounter());
	}

	@Override
	public void greet() {
		System.out.println("Hello Instructor");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	void calculateEffectiveRating() {
		int avg = 0;
		for (int i = 0; i < arrayOfFeedback.length; i++) {
			avg = avg + arrayOfFeedback[i].getRatingPoints();
		}
		rating = avg / arrayOfFeedback.length;
		System.out.println("Effective rating is: " + rating);
	}

	public class Feedback { // inner class
		private int ratingPoints;

		public Feedback(int ratingPoints) {
			if (ratingPoints >= 1 && ratingPoints <= 10) {
				this.ratingPoints = ratingPoints;
			} else {
				System.out.println("Invalid rating points provided !!");
			}
		}

		public int getRatingPoints() {
			return ratingPoints;
		}

		public void setRatingPoints(int ratingPoints) {
			this.ratingPoints = ratingPoints;
		}

	} // Feedback class ends

} // Instructor class ends
