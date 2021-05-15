package com.publicissapient.day1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.publicissapient.day2.Person;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;
import com.publicissapient.day5.exceptions.PersonException;
import com.publicissapient.day5.exceptions.StudentException;

public class Student extends Person implements Serializable {

	private ArrayList<Integer> allSubjectMarks = new ArrayList<>();

	// parameterized student constructor
	public Student(String name, String gender, String dob, ArrayList<Integer> allSubjectMarks, String email)
			throws ContactException, PersonException, EmailUniqueness {
		super(name, gender, dob, email);

		for (int i = 0; i < allSubjectMarks.size(); i++) {
			if (allSubjectMarks.get(i) > 0 && allSubjectMarks.get(i) < 100) {
				this.allSubjectMarks.add(allSubjectMarks.get(i));
			} else {
				throw new StudentException("Marks should be beetween 0 and 100");
			}
		}
	}

	public ArrayList<Integer> getAllSubjectMarks() {
		return allSubjectMarks;
	}

	public void setAllSubjectMarks(ArrayList<Integer> allSubjectMarks) {
		this.allSubjectMarks = allSubjectMarks;
	}

	public double calAverageMarks() {
		double avg = 0;
		int length = allSubjectMarks.size();
		for (int i = 0; i <= length - 1; i++) {
			avg = avg + allSubjectMarks.get(i);
		}
		return avg / length;
	}

	public int failedCount() {
		int count = 0;
		for (int i = 0; i <= allSubjectMarks.size() - 1; i++) {
			if (allSubjectMarks.get(i) < 35) {
				count += 1;
			}
		}

		return count;
	}

	@Override
	public void displayInfo() {
		greet();
		System.out.println("Student[name=" + getName() + ", Gender=" + getGender() + ", Marks=[" + allSubjectMarks.get(0)
				+ "," + allSubjectMarks.get(1) + "," + allSubjectMarks.get(2) + "," + allSubjectMarks.get(3) + ","
				+ allSubjectMarks.get(4) + "], MarksAverage=" + calAverageMarks() + ", Failed in Subjects=" + failedCount()
				+ "]" + ", person counter is: " + Person.getPersonCounter());
	}

	@Override
	public void greet() {
		System.out.println("Hello Student !");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allSubjectMarks == null) ? 0 : allSubjectMarks.hashCode());
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
		if (allSubjectMarks == null) {
			if (other.allSubjectMarks != null)
				return false;
		} else if (!allSubjectMarks.equals(other.allSubjectMarks))
			return false;
		return true;
	}


	

}
