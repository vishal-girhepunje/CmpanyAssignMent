package com.masai.dto;

public class Student {
	private int rollNo;
	private String name;
	private String address;
	private int marks;
	public Student(int rollNo, String student, String address, int marks) {
		super();
		this.rollNo = rollNo;
		this.name = student;
		this.address = address;
		this.marks = marks;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudent() {
		return name;
	}
	public void setStudent(String student) {
		this.name = student;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", student=" + name + ", address=" + address + ", marks=" + marks + "]";
	}
}
