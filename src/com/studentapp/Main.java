package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) { // String[] arg - runtime args
		System.out.println("********************* Student Management System *********************");
		System.out.println("******************* Welcome *******************");
		Student s1 = new Student("Santhoshi", 23, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("Java");
		s1.enrollCourse("Devops");
		s1.printStudentInfo();
//		System.out.println(s1);
		
		Student s2 = new Student("John", 21, "S-2");
		s2.enrollCourse("Java");
		s2.enrollCourse("DSA");
		s2.enrollCourse("Devops");
		s2.enrollCourse("C#");
		s2.printStudentInfo();
	//	System.out.println(s2);


		Student s3 = new Student("Ritu", 22, "S-13");
		s3.enrollCourse("DSA");
		s3.printStudentInfo();
	//	System.out.println(s3);


	


	}

}
