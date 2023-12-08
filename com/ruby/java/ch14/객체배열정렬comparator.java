package com.ruby.java.ch14;

/*
 * public interface Comparator<T>{
 *    public int compare(T 01, T 02);
 *    }
 *    
 * public interface Comparable<T> {
 *   public int compareTo(T o);
 *   }   
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


class Student {
	String sno;
	String sname;

	public Student(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	public String toString() {
		return "[" + sno + ", " + sname + "]";
	}
}

public class 객체배열정렬comparator {
	static void sortStudent(Student[] data, Comparator<Student> com) { // Student array type data와 Comparator interface의 Student type 인자 comp를 전달
		Student temp;
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (com.compare(data[i], data[j]) > 0) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Comparator<Student> compNo = new Comparator<Student>() { //익명 클래스로 인터페이스 구현, 인터페이스 구현과 동시에 인스턴스 생성
			@Override
//				sno를 사용하는 비교함수. int type의 결과값을 return하는 compare() method, sno를 변수로 전달받음. is used to sort.
			public int compare(Student s1, Student s2) {
				return Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
//				return s1.sno.compareTo(s2.sno); : String 비교라서 사전순이므로 Integer.parseint() 이용한다.
			}
		};

		Comparator<Student> compName = new Comparator<Student>() {
			@Override
//				int type의 결과값을 return하는 compare() method, sname를 변수로 전달받음. sname은 String type이므로 int로 변환해봄
			public int compare(Student s1, Student s2) {
//				sname을 사전순으로 비교가능
				return s1.sname.compareTo(s2.sname);
			}
		};

		Student[] data = {
				new Student("12", "홍길동"),
				new Student("12", "박길순"),
				new Student("213", "김길춘"),
				new Student("9", "이길홍") };

//		sortStudent(data, compName); // compName: 이름으로 비교, compNo: 번호로 정렬
//		Arrays.sort(data, compName);//이게 문제가 있어서 sortStudent()를 구현
//		Collections.sort(data, compNo); //Arraylist, vector, hashmap에서 Collection을 사용가능. Collections class의 sort method, data/comp parameter 전달받음
		
		Arrays.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int result = Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
				if (result == 0)
				{
					return s1.sname.compareTo(s2.sname);
				}
				return result;
			}
		});
		
		for (Student st : data) {
			System.out.print(" " + st); //Arrays.sort method 이용하여 sno 기준으로 정렬
		}
		System.out.println();

		Arrays.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
//				s1.sname의 값과 s2.sname의 값을 비교한다. compareTo() method를 이용하므로 return type은 int임. s1>s2면 양수, s1==s2면 0, s1<s2면 음수로 return, return된 값을 이용하여 Arrays.sort() method로 data[] sorting.
				return s1.sname.compareTo(s2.sname);
			}
		});
		
		for (Student st : data) {
			System.out.print(" " + st); //Arrays.sort method 이용하여 sname 기준으로 정렬
		}
	}
}
