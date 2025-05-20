package com.studentapplication;

public class Main {

	public static void main(String[] args) {
		System.out.println("===========================================");
		System.out.println("    Welcome to Student Management System");
		System.out.println("===========================================");

		Student s1;

		s1 = new Student("rick shARma", 25, "S-001");
		s1.enrollCourse("Java");
		s1.enrollCourse("Selenium");
//		s1.enrollCourse("java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("DevOps");
//		s1.enrollCourse("TestNG");
		// System.out.println(s1);

		Student s2;

		s2 = new Student("Parikshit Singh", 24, "S-002");
		s2.enrollCourse("DSA");
		s2.enrollCourse("Java");
		s2.enrollCourse("Selenium");

		Student s3;
		s3 = new Student("Simran", 22, "S-003");
		s3.enrollCourse("DevOps");
		s3.enrollCourse("java");

		s1.printStudentInfo();
		s2.printStudentInfo();
		s3.printStudentInfo();

	}

}
