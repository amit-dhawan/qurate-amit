package com.sapient.day8;

import java.util.List;

public class Teacher {
	
	
	private List<Integer> salaries;

	public Teacher(List<Integer> salaries) {
		this.salaries = salaries;
	}
	
	

	public int getAverageSalary() {
		int sum = 0;
		for (Integer salary : salaries) {
			sum = sum + salary;
		}
		return sum / salaries.size();
	}

}