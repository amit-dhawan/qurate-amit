package com.publicissapient.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.publicissapient.day1.Student;
import com.publicissapient.day5.exceptions.ContactException;
import com.publicissapient.day5.exceptions.EmailUniqueness;
import com.publicissapient.day5.exceptions.PersonException;

public class DemoStudentData {

	public static void main(String[] args) throws FileNotFoundException, EmailUniqueness {
		// BufferReader class to read user's input from console. Stream is System.in
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String proceed = "Y";
		int counter = 0;
		Student[] students = new Student[5]; // Students Array

		try {
			while (proceed.equalsIgnoreCase("Y")) {
				System.out.println("Enter Student name");
				String name = reader.readLine();
				System.out.println("Enter Student age");
				int age = Integer.parseInt(reader.readLine());
				System.out.println("Enter Student gender");
				String gender = reader.readLine();
				System.out.println("Enter Student DOB in yyyy-MM-dd format");
				String dob = reader.readLine();
				System.out.println("Enter Student marks");
				String marks = reader.readLine();
				String[] studentMarks = marks.split(" ");
				System.out.println("no of marks entered: " + studentMarks.length);
				int[] allSubjectMarks = new int[studentMarks.length];

				for (int i = 0; i < studentMarks.length; i++) {
					allSubjectMarks[i] = Integer.parseInt(studentMarks[i]);
				}
				System.out.println("Enter Student email");
				String email = reader.readLine();

				try {
					ArrayList<Integer> marksList = new ArrayList<>();
					marksList.add(50);
					marksList.add(76);
					marksList.add(80);
					students[counter] = new Student(name, gender, dob, marksList, email);
				} catch (ContactException | PersonException e) {
					e.printStackTrace();
				}

				System.out.println("Want to add another student? Enter Y if yes, else type quit to exit.");
				proceed = reader.readLine();

				counter++;

			} // while ends

			StudentsData studentsData = new StudentsData();
			studentsData.setStudents(students);

			// Creates a FileOutputStream where objects from ObjectOutputStream are written
			File file = new File("./StudentsData.txt");
			FileOutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = null;
			FileInputStream is = null;
			ObjectInputStream ois = null;

			try {
				oos = new ObjectOutputStream(os);
				oos.writeObject(studentsData);
				// read data object from file
				is = new FileInputStream(file);
				ois = new ObjectInputStream(is);

				StudentsData readStudentData = (StudentsData) ois.readObject();

				// display student info after reading deserializing StudentData object form file

				int count = 0;
				for (Student s : readStudentData.getStudents()) {

					if (s != null) {
						count++;
						System.out.println();
						s.displayInfo();

					} else {
						System.out.println("\nInformation entered for: " + count + " students");
						break;
					}
				}

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				os.close();
				is.close();
				oos.close();
				ois.close();
			}

		} catch (IOException e1) { // outer try-catch Block
			e1.printStackTrace();
		}

	} // main ends
}
