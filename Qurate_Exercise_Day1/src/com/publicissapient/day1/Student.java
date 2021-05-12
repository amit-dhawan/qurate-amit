package com.publicissapient.day1;

import java.io.Serializable;
import java.util.Arrays;

import com.publicissapient.day2.Person;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.PersonException;
import com.publicissapient.day5.exceptions.StudentException;

public class Student extends Person implements Serializable {

	private int[] allSubjectMarks = new int[5];

	// parameterized student constructor
	public Student(String name, Integer age, String gender, int[] allSubjectMarks, String email) throws ContactException, PersonException {
		super(name, age, gender, email);

		for (int i = 0; i < allSubjectMarks.length; i++) {
			if (allSubjectMarks[i] > 0 && allSubjectMarks[i] < 100) {
				this.allSubjectMarks[i] = allSubjectMarks[i];
			} else {
				throw new StudentException("Marks should be beetween 0 and 100");
			}
		}
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
				+ failedCount() + "]" + ", person counter is: " + Person.getPersonCounter());
	}

	@Override
	public void greet() {
		System.out.println("Hello Student");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(allSubjectMarks);
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
		Student other = (Student) obj;
		if (!Arrays.equals(allSubjectMarks, other.allSubjectMarks))
			return false;
		return true;
	}

}
