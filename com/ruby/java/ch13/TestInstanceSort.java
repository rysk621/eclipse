package com.ruby.java.ch13;

import java.util.Arrays;

class Student implements Comparable<Student> {
	String sno;
	String sname;

	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "["+sno+", "+sname+"]";
	}

	@Override
	public int compareTo(Student s) {
		int n = Integer.parseInt(this.sno);
		int m = Integer.parseInt(s.sno);
		return n - m;//int를 compare하는 함수
	}
}

public class TestInstanceSort {

	static void sortStudent(Student[] data) {
		Student temp;
		for (int i = 0; i < data.length; i++) {//정렬하는 함수 만들기. ascending order
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j])>0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Student[] data = {
				new Student("12", "홍길동"),
				new Student("121", "홍길순"),
				new Student("213", "홍길춘"),
				new Student("9", "홍길홍") };
		for (Student st : data) //data array의 elements st에 대하여 for loop 실행
			System.out.print(st+" ");
		System.out.println();
		//sortStudent(data); //위에서 정의했던 student sorting method sortStudent()를 실행
		Arrays.sort(data);//이게 문제가 있어서 sortStudent()를 구현
		for (Student st : data) //data array의 elements st에 대하여 for loop 실행
			System.out.print(st+" ");
		}

}
