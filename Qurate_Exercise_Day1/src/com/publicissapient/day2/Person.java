package com.publicissapient.day2;

import com.publicissapient.day1.Student;
import com.publicissapient.day3.Contactable;
import com.publicissapient.day3.Greetable;

public class Person extends Contactable implements Greetable {

	private String name;
	private Integer age;
	private String gender;
	StringBuffer sb = new StringBuffer("Person");

	private static Integer personCounter = Integer.valueOf(0);

	// parameterized constructor1
	public Person(String name, Integer age, String gender, String email) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.setEmail_Id(email);
		personCounter++;
	}

	// parameterized constructor2
	public Person(Student student) {
		personCounter++;
		this.name = student.getName();
		this.age = student.getAge();
		this.gender = student.getGender();
	}

// defaut constructor. constructor chaining calling constructor1
	public Person() {

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
		sb.append(" [name=").append(getName()).append(", Age=").append(age).append(", Gender=").append(getGender()).append("]").append(", person counter is: ");
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
