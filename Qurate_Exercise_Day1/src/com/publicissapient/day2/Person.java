package com.publicissapient.day2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.publicissapient.day1.Student;
import com.publicissapient.day3.Contactable;
import com.publicissapient.day3.Greetable;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.PersonException;

public class Person extends Contactable implements Greetable {

	private String name;
	private Integer age;
	private String gender;
	StringBuffer sb = new StringBuffer("Person");

	private static Integer personCounter = Integer.valueOf(0);

	// parameterized constructor1
	public Person(String name, Integer age, String gender, String email) throws ContactException, PersonException {

		super(email);
		String regex = "([a-zA-Z\\-]+){2,}\\s+([a-zA-Z\\-]+){2,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name.trim());
		System.out.println(matcher.matches());
		System.out.println(name);
		if (matcher.matches()) {
			this.name = name;

		} else {
			throw new PersonException(
					"Name: should only contain alphabets (a-z A-Z) and spaces. No numbers and special characters");
		}

		if (age > 10 && age < 80) {
			this.age = age;
		} else {
			throw new PersonException("Age should be between 10 to 80");
		}

		this.gender = gender;

		personCounter++;
	}

	// parameterized constructor2
	public Person(Student student) throws ContactException {
		super("_NO_EMAIL_");
		personCounter++;
		this.name = student.getName();
		this.age = student.getAge();
		this.gender = student.getGender();

	}

// defaut constructor. constructor chaining calling constructor1
	public Person() throws ContactException, PersonException {

		this("_DEFAULT_", 0, "N/A", "no_email_set");
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void displayInfo() {
		greet();
		sb.append(" [name=").append(getName()).append(", Age=").append(age).append(", Gender=").append(getGender())
				.append("]").append(", person counter is: ");
		sb.append(Person.getPersonCounter());
		System.out.println(sb);
//		System.out.println("Person [name=" + getName() + ", Age=" + age + ", Gender=" + getGender() + "]"
//				+ ", person counter is: " + Person.getPersonCounter());
	}

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
		return "Name:" + name + " Age: " + age + " Gender:" + gender;
	}

	@Override
	public void displayContactInfo() {
		System.out.println("EmaiID is: " + getEmail_Id());

	}

	@Override
	public void greet() {
		System.out.println("hello Person !");
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
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
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
