package com.publicissapient.day1;

import com.publicissapient.day2.Person;
import com.publicissapient.day3.Instructor;

public class Demo {

	public static void main(String[] args) {
		
		Person instructorType = new Instructor("Jackson", 30, "M", "Into to Java", 10);
		instructorType.displayInfo();
		
		Person studentType = new Student("Amit", 20, "M", new int[] {50, 20, 90,91, 65});
		studentType.displayInfo();
		
		
		

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
	//	Person defaultPerson = new Person();
	//	defaultPerson.displayInfo();
		

		// loop display info Day1 exercise
//		for (int i = 0; i < arrayOfStudents.length; i++) {
//			arrayOfStudents[i].displayInfo();
//		}

	//	 displayGenderCount(arrayOfStudents); // call display gender method
		
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
