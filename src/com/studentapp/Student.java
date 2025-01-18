package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	// attributes/instance vars - vars created inside class and are non-static
	// IV marked with private (protects from illegal value assignment)
	// IV created in heap memory with default values
	private String name;
	private int age;
	private String studentId;
	private List<String> courses = null;

	// constructor - initialize IV
	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			// creating obj of ArrayList class
			courses = new ArrayList<String>(); // Initialization of courses!!
		}
	}

	public void enrollCourse(String course) {
		// contains - to check if a certain object is part of ArrayList
		// ArrayList is non idempotent in nature (can have duplicate elements)
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " successfully!!");
			} else {
				System.err.println("Student is already enrolled to the course " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("=============== Student Information ===============");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled For: " + courses);

	}

	// in one line we get the state/values of IV using toString()
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// validation Methods - always private
	private boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid age!!! Student Age needs to be between 19 and 35");
			return false;
		}
	}

	private boolean validateName(String name) {
		// Kajal kajal kaJaL KAJAL Talreja
		// ^ indicates String should start with alphabet{upper/lower}& spaces
		// \\s indicates white spaces are allowed in the string
		// + indicates n no of combinations (with alphabets and spaces)
		// $ always end with (alpha - upper lower , space)
		String nameRegex = "^[a-zA-z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name!!! Please enter alphabets only");
			return false;
		}
	}

	private boolean validateStudentId(String studentId) {
		// S-123
		String studentIdRegex = "S-[0-9]+$"; // S-\\d+$
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student Id!!! Use the format Eg... S-123");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
			return true;
		} else {
			System.err.println("Invalid Course Name!!! Please select Courses from the List!! [Java,DSA,Devops]");
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
