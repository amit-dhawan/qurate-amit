package com.publicissapient.day6;

import java.io.Serializable;

import com.publicissapient.day1.Student;

public class StudentsData implements Serializable {

	Student[] students;

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

}
