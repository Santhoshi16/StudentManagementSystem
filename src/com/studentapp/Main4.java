package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {

	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("********************* Student Management System *********************");
		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
	while(true) {
		System.out.println("******************* Welcome *******************");

		System.out.println("Select an Option.....");
		System.out.println("1. Register a Student");
		System.out.println("2. Find Student with studentId");
		System.out.println("3. List All Student Information");
		System.out.println("4. List Student Information in Sorted Order");
		System.out.println("5. Exit");
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			enrollStudent(scanner);
			break;
		case 2:
			findStudentById(scanner);
			break;
		case 3:
			printAllStudentsData();
			break;
		case 4:
			sortByName();
			break;
		case 5:
			exit();
			break;

		default:
			System.out.println("Invalid option selected!...Enter between 1 to 5");
		}
	}
	}

	private static void exit() {
		System.out.println("Good Bye!!!");
		System.exit(0);
	}

	private static void printAllStudentsData() {
		if(studentList.size()>0) {
		System.out.println("----------- Printing All Students Data -----------");
		for(Student student: studentList) {
			student.printStudentInfo();
		}
		System.out.println("-----------*******************-----------");
		}else {
			System.err.println("Student List is Empty!!! No Student Record is Found!!");
		}

	}

	private static void findStudentById(Scanner scanner) {
		System.out.println("Enter Student ID....");
		String studentId = scanner.next();
		Student studentFound = findStudentById(studentId);
		studentFound.printStudentInfo();

	}

	private static void enrollStudent(Scanner scanner) {
		System.out.println("Enter the Student Name");
		String studentName = scanner.next();
		
		System.out.println("Enter the Student Age");
		int studentAge = scanner.nextInt();
		
		System.out.println("Enter the Student Id");
		String studentId = scanner.next();
		
		Student newStudent = new Student(studentName,studentAge,studentId);
		studentList.add(newStudent);
		while(true) { //to enroll to multiple courses - program not terminated immediately after one course added
		System.out.println("Enter the Course to be Enrolled!!...Type Done to Exit");
		String courseName = scanner.next();
		if(courseName.equalsIgnoreCase("Done")) {
			break;//exit from the loop, use break!!
		}
		newStudent.enrollCourse(courseName);
	}
		newStudent.printStudentInfo();
	}
	private static void sortByName() {
		/*
		 * Comparator<Student> studentNameComparator = new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student o1, Student o2) { return
		 * o1.getName().compareTo(o2.getName());//lexographically compare } };
		 */

		// lambda expressions make ur code concise and smaller in size and reduce the
		// boiler plate code
		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		
		Collections.sort(studentList, studentNameComparator);
		printAllStudentsData();
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
