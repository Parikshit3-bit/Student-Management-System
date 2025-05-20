package com.studentapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("    Welcome to Student Management System");
		System.out.println("===========================================");
		studentList = new ArrayList<Student>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Name...");
		String name = sc.next();
		System.out.println("you have entered the name "+name);
		
		
		System.out.println("Enter Student age ");
		int age = sc.nextInt();
		System.out.println("The Student age is "+age);

	}

	private static void sortByName() {
		Comparator<Student> StudentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

		/*
		 * new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { // TODO Auto-generated
		 * method stub return o1.getName().compareTo(o2.getName()); } };
		 * 
		 */
		Collections.sort(studentList, StudentNameComparator);
		System.out.println(studentList);

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
