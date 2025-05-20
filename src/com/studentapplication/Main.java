package com.studentapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("     Student Management System");
		System.out.println("===========================================");
		studentList = new ArrayList<Student>();
		Scanner sc1 = new Scanner(System.in);
		while (true) {
			System.out.println("**************** Welcome ****************");
			System.out.println("Select an Option.....");
			System.out.println("1. Register a Student");
			System.out.println("2. Find a Student with StudentID");
			System.out.println("3. List All Student Information");
			System.out.println("4. List Student Information in Sorted order");
			System.out.println("5. Exit");

			int option = sc1.nextInt();

			switch (option) {
			case 1:
				enrollStudent(sc1);
				break;
			case 2:
				findStudentById(sc1);
				break;
			case 3:
				printAllStudentData(sc1);
				break;
			case 4:
				sortByName(sc1);
				break;
			case 5:
				Exit();
				break;

			default:
				System.out.println("Invalid Option selected!... Enter between 1 to 5");
			}
		}

	}

	private static void Exit() {
		System.out.println("Successfully Exited ");
		System.exit(0);
		
	}

	private static void printAllStudentData(Scanner sc1) {
		if (studentList.size() > 0) {
			System.out.println("-------------------- Printing Student Data --------------------");
			for (Student student : studentList) {
				student.printStudentInfo();
			}
			System.out.println("--------------------- ******************************** ---------------------------");
		} else {
			System.out.println("Student list is Empty!!! No Student Record Found..");
		}
	}

	private static void findStudentById(Scanner sc1) {

		Student studentFound = null;
		System.out.println("Enter the Student Id");
		String studentId = sc1.next();
		try {
			studentFound = studentList.stream()
					.filter(studentid -> studentid.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");

		}

		studentFound.printStudentInfo();

	}

	private static void enrollStudent(Scanner sc1) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Student Name");
		String studentName = sc1.next();

		System.out.println("Enter the Student age");
		int age = sc1.nextInt();

		System.out.println("Enter the Student Id");
		String studentId = sc1.next();

		Student newStudent = new Student(studentName, age, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrolled!!.... Type Done to exit");
			String courseName = sc1.next();
			if (courseName.equalsIgnoreCase("Done")) {
				break;
			}
			newStudent.enrollCourse(courseName);
			System.out.println("Enrolled to the course!!");
		}
		newStudent.printStudentInfo();

	}

	private static void sortByName(Scanner sc1) {
		Comparator<Student> StudentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { // TODO Auto-generated
		 * method stub return o1.getName().compareTo(o2.getName()); } };
		 * 
		 */
		Collections.sort(studentList, Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));
		printAllStudentData(sc1);

	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(studentid -> studentid.getStudentId().equalsIgnoreCase(studentId))
					.findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		return result;
	}

}
