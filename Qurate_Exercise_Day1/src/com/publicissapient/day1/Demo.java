package com.publicissapient.day1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.publicissapient.day2.Person;
import com.publicissapient.day3.Instructor;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;
import com.publicissapient.day5.exceptions.PersonException;
import com.sapient.day7.Invitation;

public class Demo {

	public static void main(String[] args) throws EmailUniqueness {

		Student student1 = null;

		try {
			ArrayList<Integer> marksList = new ArrayList<>();
			marksList.add(10);
			marksList.add(76);
			marksList.add(80);
			marksList.add(90);
			marksList.add(88);

			student1 = new Student("Ravi Student", "M", "1990-01-14", marksList, "student@mail.com");
			student1.displayInfo();
//			System.out.println("\n ----------------- \n");
		} catch (ContactException | PersonException e) {

			e.printStackTrace();
		}

		Person personOne = null;
		try {
			personOne = new Person("Amit Dhawan", "M", "1985-12-19", "person@mail.com");

			System.out.println();
			personOne.displayInfo();
			System.out.println();

			/*
			 * 
			 * z * System.out.println("\n ----------------- \n");
			 */
		} catch (ContactException | PersonException e) {

			e.printStackTrace();
		}

		try {
			Instructor instructor1 = new Instructor("Vaibhav Instructor", "M", "1975-10-28", "Java",
					"instructo1@mail.com");
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

			Invitation<Instructor> inviteInstructor = new Invitation<Instructor>("Java", "Please come to Java class...",
					LocalDate.parse("2021-05-20"), instructor1);

			Invitation<Person> invitePerson = new Invitation<Person>("Java", "Please come to Java class...",
					LocalDate.parse("2021-05-27"), personOne);

			Invitation<Student> inviteStudent = new Invitation<Student>("Java", "Please come to Java class...",
					LocalDate.parse("2021-05-28"), student1);

			inviteInstructor.sendInvitation();
			inviteInstructor.forwardInvitation(invitePerson);
			inviteStudent.sendInvitation();
			

//			System.out.println("\n ----------------- \n");

			Instructor instructor2 = new Instructor("Sunil Kumar", "M", "1980-01-30", "Java", "instructo2@mail.com");
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

		} catch (ContactException | PersonException e) {

			e.printStackTrace();
		}

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
			if (s[i].getGender().equals("M")) {
				maleCount++;

			} else {
				femaleCount++;
			}
		}
		System.out.println("\nCount of male students = " + maleCount);
		System.out.println("Count of female students = " + femaleCount);
	}
}
