package com.studentapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main2 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("    Welcome to Student Management System");
		System.out.println("===========================================");
		studentList = new ArrayList<Student>();
		Student s1;

		s1 = new Student("rick shARma", 25, "S-001");
		s1.enrollCourse("Java");
		s1.enrollCourse("Selenium");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");

		Student s2;

		s2 = new Student("Parikshit Singh", 24, "S-002");
		s2.enrollCourse("DSA");
		s2.enrollCourse("Java");
		s2.enrollCourse("Selenium");

		Student s3;
		s3 = new Student("Simran", 22, "S-003");
		s3.enrollCourse("DevOps");
		s3.enrollCourse("java");
		
		Student s4;
		s4 = new Student("Avi",25,"S-134");
		s4.enrollCourse("DSA");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);

		Student result = findStudentById("S-134");
		System.out.println("Result " + result);
		sortByName();

	}

	private static void sortByName() {
		Comparator<Student> StudentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		
		/*
		 * new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		 */
		Collections.sort(studentList, StudentNameComparator);
		System.out.println(studentList);
		
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
				result = studentList.stream().filter(studentid -> studentid.getStudentId().equalsIgnoreCase(studentId))
				.findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentId+" not found!!");
		}
		return result;
	}


}
