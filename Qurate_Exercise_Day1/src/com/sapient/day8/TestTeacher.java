package com.sapient.day8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestTeacher {

	@Test
	public void testGetAverageSalary() {
		List<Integer> salaries = new ArrayList<>();
		salaries.add(200);
		salaries.add(150);
		salaries.add(250);

		Teacher teacher = new Teacher(salaries);
		int avgSalary = teacher.getAverageSalary();

		assertEquals(200, avgSalary);

	}

	@Test(expected = ArithmeticException.class)
	public void testGetAverageSalary_Zero() {
		List<Integer> salaries = new ArrayList<>();

		Teacher teacher = new Teacher(salaries);
		int avgSalary = teacher.getAverageSalary();

	}
}