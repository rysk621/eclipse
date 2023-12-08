package com.ruby.java.ch10.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ruby.java.ch10.Person;
import com.ruby.java.ch10.Professor;
import com.ruby.java.ch10.Student;

public class Test01_ArrayList {
	public static void main(String[] args) {
		
		Random rd = new Random();
		List<Person> list = new ArrayList<>(); //부모 클래스의 참조변수 타입을 데이터타입으로 설정, 자손 클래스를 포함할 수 있음
		
		Professor p1 = new Professor();
		p1.setName("교수1");
		p1.setAge(41);
		p1.setSubject("JAVA");
		list.add(p1);
		
		Professor p2 = new Professor();
		p2.setName("교수2");
		p2.setAge(50);
		p2.setSubject("Python");
		list.add(p2);
		
		for (int i = 1; i <= 10 ; i++) {
			Student s = new Student();
			s.setName("학생"+i);
			s.setAge(rd.nextInt(20,30));
			s.setMajor("컴공과");
			list.add(s);
		}
//		list.forEach(p->System.out.println(p));
//		System.out.println(list); //list에는 toString 있어서 String type으로 반환됨.
		
		list.clear();
		
		Professor p3 = new Professor("교수1", 41, "JAVA");
		Professor p4 = new Professor("교수2", 50, "Python");
		list.add(p3);
		list.add(p4);
		for (int i = 1 ; i<=10;i++) {
			Student s = new Student("학생"+i,rd.nextInt(20,30),"컴공과");
			list.add(s);
		}
		System.out.println(list);
		list.forEach(p->System.out.println(p));
	}
}