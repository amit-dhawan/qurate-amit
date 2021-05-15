package com.publicissapient.day2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.publicissapient.day1.Student;
import com.publicissapient.day3.Contactable;
import com.publicissapient.day3.Greetable;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;
import com.publicissapient.day5.exceptions.PersonException;

public class Person extends Contactable implements Greetable, Serializable {

	static final long serialVersionUID = 123;
// class variables declaration
	private String name;
	private GENDER gender;
	private LocalDate dob;
	private StringBuffer sb = new StringBuffer("Person");
	private static Integer personCounter = Integer.valueOf(0);

	// enum declaration
	public enum GENDER {
		M, F
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	// parameterized constructor1
	public Person(String name, String gender, String sDoB, String email) throws ContactException, PersonException, EmailUniqueness {
		super(email);
		setDob(LocalDate.parse(sDoB));
		String regex = "([a-zA-Z\\-]+){2,}\\s+([a-zA-Z\\-]+){2,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name.trim());

		if (matcher.matches()) {
			this.name = name;

		} else {
			throw new PersonException(
					"Name: should only contain alphabets (a-z A-Z) and spaces. No numbers and special characters");
		}

		if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("M")) {
			this.gender = GENDER.M;
		} else if (gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("F")) {
			this.gender = GENDER.F;
		} else {
			new PersonException("gender should be M or F");

		}
		personCounter++;
	}

	// parameterized constructor2
	public Person(Student student) throws ContactException, EmailUniqueness {
		super("_NO_EMAIL_");
		personCounter++;
		this.name = student.getName();
		this.gender = student.getGender();

	}

// defaut constructor. constructor chaining calling constructor1
	public Person() throws ContactException, PersonException, EmailUniqueness {
		this("_DEFAULT_", "N/A", "1900-01-01", "no_email_set");
	}

	public static int getPersonCounter() {
		return personCounter;
	}

	public static void setPersonCounter(int personCounter) {
		Person.personCounter = personCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public void displayInfo() {
		int age = getPersonAge(getDob());
		String dateOfBirth = getPersonDob(getDob());
		greet();
		sb.append("[name=").append(getName()).append(", Gender=").append(getGender()).append(", DOB = ")
				.append(dateOfBirth).append(", age=").append(age).append("]").append(", person counter is: ");
		sb.append(Person.getPersonCounter());
		System.out.println(sb);
	}

	private int getPersonAge(LocalDate dob) {
		LocalDate today = LocalDate.now();
		Period period = Period.between(dob, today);
		int age = period.getYears();

		return age;
	}

	private String getPersonDob(LocalDate dob) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM-dd-YYYY");
		String personDOB = dob.format(dateFormat);

		return personDOB;
	}

	// overloaded displayInfo method
	public void displayInfo(Student student) {
		greet();
		student.displayInfo();
	}

	// overloaded method varargs ... or []
	public void displayInfo(Student... students) {
		greet();
		for (Student s : students) {
			s.displayInfo();
		} // enhanced for loop
	}

	@Override
	public String toString() {
		return "Name:" + name + " Gender:" + gender;
	}

	@Override
	public void displayContactInfo() {
		System.out.println("EmaiID is: " + getEmail_Id());
	}

	@Override
	public void greet() {
		System.out.println("Hello Person !");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
