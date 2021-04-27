package com.publicissapient.day1;

import com.publicissapient.day2.Person;

public class Student extends Person {

	private int[] allSubjectMarks = new int[5];

	// parameterized student constructor
	public Student(String name, int age, String gender, int[] allSubjectMarks) {
		super(name, age, gender);
		this.allSubjectMarks = allSubjectMarks;
	}

	public int[] getAllSubjectMarks() {
		return allSubjectMarks;
	}

	public void setAllSubjectMarks(int[] allSubjectMarks) {
		this.allSubjectMarks = allSubjectMarks;
	}

	public double calAverageMarks() {
		double avg = 0;
		int length = allSubjectMarks.length;
		for (int i = 0; i <= length - 1; i++) {
			avg = avg + allSubjectMarks[i];
		}
		return avg / length;
	}

	public int failedCount() {
		int count = 0;
		for (int i = 0; i <= allSubjectMarks.length - 1; i++) {
			if (allSubjectMarks[i] < 35) {
				count += 1;
			}
		}

		return count;
	}

	@Override
	public void displayInfo() {
		greet();
		System.out.println("Student[name=" + getName() + ", Age=" + getAge() + ", Gender=" + getGender() + ", Marks=["
				+ allSubjectMarks[0] + "," + allSubjectMarks[1] + "," + allSubjectMarks[2] + "," + allSubjectMarks[3]
				+ "," + allSubjectMarks[4] + "], MarksAverage=" + calAverageMarks() + ", Failed in Subjects="
				+ failedCount() + "]"  + ", person counter is: " +Person.getPersonCounter());
	}
	
	@Override
	public void greet() {
		System.out.println("Hello Student");
	}
}
