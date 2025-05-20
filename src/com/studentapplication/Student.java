package com.studentapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;

			courses = new ArrayList<String>(); // Initialization of courses
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);

			} else {
				System.err.println("Student has already Enrolled for this course : " + course);
			}

		}

	}

	public void printStudentInfo() {
		System.out.println("============= Student Information ============= ");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);

		if (!courses.isEmpty()) {
			String courseList = String.join(", ", courses);
			System.out.println("Enrolled Courses: " + courses);
			System.out.println(name + " is Enrolled to " + courseList + " successfully");
		} else {
			System.out.println(name + " is not enrolled in any courses yet");
		}
		System.out.println();

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// Validation for age (Student age should be between 19 and 35)
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age : Student age must be between 19 and 35");
			return false;
		}

	}

	public boolean validateName(String name) {

		// Parikshit //parikshit //parIKshit // Parikshit Singh // pariksHIt SingH //
		// any combination
		String nameRegex = "^[a-zA-z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name : Please enter alphabets only");
			return false;
		}

	}

	public boolean validateStudentId(String studentId) {
		String studentIdregex = "S-[0-9]+$";// S-123
		Pattern studentIdpattern = Pattern.compile(studentIdregex);
		Matcher studentIdMatcher = studentIdpattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid StudentId : Enter a Valid StudentId   Eg....S-123");
			return false;
		}

	}

	public boolean validateCourseName(String coursename) {
		if (coursename.equalsIgnoreCase("Java") || coursename.equalsIgnoreCase("Selenium")
				|| coursename.equalsIgnoreCase("DSA") || coursename.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println(
					"Invalid Course Name : Please select the course from the list [Java,Selenium,DSA, DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
