package com.publicissapient.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.publicissapient.day2.Person;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;
import com.publicissapient.day5.exceptions.InstructorException;
import com.publicissapient.day5.exceptions.PersonException;

public class Instructor extends Person {

	private static final long serialVersionUID = 1001L;
	private String subject;
	private Float rating;
	private Feedback[] arrayOfFeedback;
	private String regex = "^[a-zA-Z\s0-9]+$";
	private Pattern pattern = Pattern.compile(regex);

	public Feedback[] getArrayOfFeedback() {
		return arrayOfFeedback;
	}

	public void setArrayOfFeedback(Feedback[] arrayOfFeedback) {
		this.arrayOfFeedback = arrayOfFeedback;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Instructor(String name, String gender, String dob, String subject, String email)
			throws ContactException, PersonException, InstructorException, EmailUniqueness {
		super(name, gender, dob, email);

		Matcher matcher = pattern.matcher(subject);
		if (matcher.find()) {
			this.setSubject(subject);
		} else {
			throw new InstructorException(
					"Subject name should be - alphanumeric characters (a-z A-Z 0-9) and spaces. No special chars");
		}
	}

	public Instructor() throws ContactException, PersonException, EmailUniqueness {

	}

	public String getSubject() {
		return subject;
	}

	public Float getRating() {
		return rating;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRatingComments(Float rating) {
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
		System.out.println("Instructor[name=" + getName() + ", Gender=" + getGender() + ", Subject Name=" + getSubject()
				+ ", Rating=" + getRating() + ", Rating Comment=" + getRatingComments(getRating()) + "]"
				+ ", person counter is: " + Person.getPersonCounter());
	}

	@Override
	public void greet() {
		System.out.println("Hello Instructor !");
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
		float avg = 0;
		for (int i = 0; i < arrayOfFeedback.length; i++) {
			avg = avg + arrayOfFeedback[i].getRatingPoints();
		}
		rating = avg / arrayOfFeedback.length;
		System.out.println("Effective rating is: " + rating);
	}

	public class Feedback { // inner class
		private Integer ratingPoints;

		public Feedback(Integer ratingPoints) throws InstructorException {
			if (ratingPoints >= 1 && ratingPoints <= 10) {
				this.ratingPoints = ratingPoints;
			} else {
				throw new InstructorException("rating should be between 0 and 10");
			}
		}

		public Integer getRatingPoints() {
			return ratingPoints;
		}

		public void setRatingPoints(int ratingPoints) {
			this.ratingPoints = ratingPoints;
		}

	} // Feedback class ends

} // Instructor class ends
