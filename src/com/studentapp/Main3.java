package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentList;

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		System.out.println("******************* Welcome *******************");
		studentList = new ArrayList<Student>();
		
		//Read input from terminal
		Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Student Name...");
		String name =	scanner.next(); //read input in String format we use next()
		System.out.println("You have entered the name: "+name);
		
			 //to read integer values from the console use readInt()
		System.out.println("Enter Student Age...");
		int age =	scanner.nextInt(); //read input in int format we use nextInt()
		System.out.println("You have entered the age: "+age);

			
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
