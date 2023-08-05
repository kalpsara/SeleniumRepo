package org.student;

import org.department.Department;

//studentName(),studentDept(),studentId()
public class Student extends Department {

	String deptName = "CSC";

	// String deptName="CSC";

	String stName = "Kalpana";

	int stId = 1231;

	public String studentName() {
		return stName;
	}

	public String studentDept() {
		return deptName;
	}

	public int studentId() {
		return stId;
	}

	public static void main(String[] args) {

		Student s = new Student();

		System.out.println("----College Details----");
		System.out.println("College name: " + s.collegeName());

		System.out.println("College code: " + s.collegeCode());

		System.out.println("College rank: " + s.collegeRank());

		System.out.println("Courses availble: " + s.deptName());

		System.out.println("Student ID:" + s.studentId());

		System.out.println("Student name:" + s.studentName());

		System.out.println("Student dept:" + s.studentDept());

	}

}
