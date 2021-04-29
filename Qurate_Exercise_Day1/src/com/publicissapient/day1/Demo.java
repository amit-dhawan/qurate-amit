package com.publicissapient.day1;

import com.publicissapient.day2.Person;
import com.publicissapient.day3.Instructor;

public class Demo {

	public static void main(String[] args) {

		Instructor instructorType = new Instructor("Jackson", 30, "M", "Into to Java", "instructor1@test.com");
		Person instructorType1 = new Instructor("Jackson", 30, "M", "Into to Java", "person1@test.com");
		Person studentType = new Student("Amit", 20, "M", new int[] { 50, 20, 90, 91, 65 }, "student@mail.com");
		studentType.displayInfo();
		System.out.println("Is instructorType is equal to studentType: " + instructorType.equals(studentType));
		System.out.println("Is instructorType is equal to instructorType1: " + instructorType.equals(instructorType1));

		Student student1 = new Student("Amit", 20, "M", new int[] { 50, 75, 98 }, "student@mail.com");
		Student student2 = new Student("Amit", 20, "M", new int[] { 50, 75, 98 }, "student@mail.com");
		Student student3 = new Student("Vineet", 20, "M", new int[] { 50, 75, 98 }, "student@mail.com");
		System.out.println("Is student1 is equal to student2: " + student1.equals(student2));
		System.out.println("Is student1 is equal to student3: " + student1.equals(student3));

		Person personOne = new Person("APerson", 30, "M", "person@mail.com");
		personOne.displayInfo();

		Instructor instructor1 = new Instructor("Vaibhav", 35, "M", "Java", "instructo1@mail.com");
		Instructor.Feedback instructor1feedback1 = instructor1.new Feedback(8); // create object of inner class
		Instructor.Feedback instructor1feedback2 = instructor1.new Feedback(7); // create object of inner class
		Instructor.Feedback instructor1feedback3 = instructor1.new Feedback(9); // create object of inner class
		Instructor.Feedback instructor1feedback4 = instructor1.new Feedback(9); // create object of inner class
		Instructor.Feedback instructor1feedback5 = instructor1.new Feedback(6); // create object of inner class
		// Array of Feedback
		Instructor.Feedback[] feedbackArray = new Instructor.Feedback[5];
		feedbackArray[0] = instructor1feedback1;
		feedbackArray[1] = instructor1feedback2;
		feedbackArray[2] = instructor1feedback3;
		feedbackArray[3] = instructor1feedback4;
		feedbackArray[4] = instructor1feedback5;

		instructor1.setArrayOfFeedback(feedbackArray);
		instructor1.displayInfo();

		Instructor instructor2 = new Instructor("Sunil", 30, "M", "Java", "instructo2@mail.com");
		Instructor.Feedback instructor2feedback1 = instructor1.new Feedback(8); // create object of inner class
		Instructor.Feedback instructor2feedback2 = instructor1.new Feedback(8); // create object of inner class
		Instructor.Feedback instructor2feedback3 = instructor1.new Feedback(8); // create object of inner class
		Instructor.Feedback instructor2feedback4 = instructor1.new Feedback(8); // create object of inner class
		Instructor.Feedback instructor2feedback5 = instructor1.new Feedback(8); // create object of inner class
		// Array of Feedback
		Instructor.Feedback[] feedbacks2 = new Instructor.Feedback[5];
		feedbacks2[0] = instructor2feedback1;
		feedbacks2[1] = instructor2feedback2;
		feedbacks2[2] = instructor2feedback3;
		feedbacks2[3] = instructor2feedback4;
		feedbacks2[4] = instructor2feedback5;

		instructor2.setArrayOfFeedback(feedbacks2);
		instructor2.displayInfo();

//		Student arrayOfStudents[] = new Student[3]; // Array of 3 students objects
//		arrayOfStudents[0] = new Student("Amit", 18, "M", new int[] { 99, 95, 88, 30, 90 });
//		arrayOfStudents[1] = new Student("Vineet", 17, "M", new int[] { 90, 85, 88, 20, 15 });
//		arrayOfStudents[2] = new Student("Priya", 18, "F", new int[] { 19, 91, 80, 65, 70 });
//		
		// Student person
//		Person studentPerson = new Person (arrayOfStudents[0]);	
//		studentPerson.displayInfo();
//		studentPerson.displayInfo(arrayOfStudents[1]);
//		studentPerson.displayInfo(arrayOfStudents);

		// default person
		// Person defaultPerson = new Person();
		// defaultPerson.displayInfo();

		// loop display info Day1 exercise
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			arrayOfStudents[i].displayInfo();
//		}

		// displayGenderCount(arrayOfStudents); // call display gender method

	} // main ends

	public static void displayGenderCount(Student[] s) {
		int maleCount = 0;
		int femaleCount = 0;
		for (int i = 0; i <= s.length - 1; i++) {
			if (s[i].getGender() == "M") {
				maleCount++;

			} else {
				femaleCount++;
			}
		}
		System.out.println("\nCount of male students = " + maleCount);
		System.out.println("Count of female students = " + femaleCount);
	}
}
