package com.ruby.java.ch10;

public class Student extends Person {
	private String major;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" : "+major;
	}
	
	public Student() {
		//System.out.println("Student 생성자 실행");
	}

	public Student(String name, int age, String major) {
		super(name, age);
		this.major = major;
	}
}
