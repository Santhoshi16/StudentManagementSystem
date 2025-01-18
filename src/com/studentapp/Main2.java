package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		System.out.println("******************* Welcome *******************");
		studentList = new ArrayList<Student>();
		Student s1 = new Student("Santhoshi", 23, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("Java");
		s1.enrollCourse("Devops");
		// s1.printStudentInfo();
//		System.out.println(s1);

		Student s2 = new Student("John", 21, "S-2");
		s2.enrollCourse("Java");
		// s2.printStudentInfo();
		// System.out.println(s2);

		Student s3 = new Student("Ritu", 22, "S-13");
		s3.enrollCourse("DSA");
		// s3.printStudentInfo();
		// System.out.println(s3);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		Student result = findStudentById("S-5");
		System.out.println("Result: " + result);
		sortByName();
		
		
	}

	private static void sortByName() {
		/*
		 * Comparator<Student> studentNameComparator = new Comparator<Student>() {
		  
		  @Override public int compare(Student o1, Student o2) { return
		  o1.getName().compareTo(o2.getName());//lexographically compare } };
		 */
		
	//lambda expressions make ur code concise and smaller in size and reduce the boiler plate code	
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null; // local vars needs to be explicitly initialized
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No Data Found!!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");// custom err msg
		}
		return result;
	}

}
