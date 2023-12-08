package com.ruby.java.ch14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student2 {
	String sno;
	String sname;
	
	public Student2 (String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}
	
	@Override
	public String toString() {
		return "[ " + sno + ", " + sname + " ]";
	}
}

public class 객체리스트정렬comparator {
	static void sortStudent(List<Student2> data, Comparator<Student2> comp) { //list data의 elements를 이용, comp 실행.
		Student2 temp;
		for (int i = 0; i < data.size();i++) { 
			for (int j = i + 1; j < data.size(); j++) {
//				if ((Integer.parseInt(data.get(i).sno)) > Integer.parseInt(data.get(j).sno)) {}
				if (comp.compare(data.get(i), data.get(j)) > 0) { //comp 객체의 compare method 이용, data.get(i)와 data.get(j)를 비교하여 i번째가 j번째보다 큰 경우 순서 변경 예정.
					temp = data.get(i); //i번째 data를 temp에 전달한다.
					data.set(i, data.get(j)); //list data의 element(인스턴스)는 get() method 이용하여 element를 불러왔으므로 바뀔 수 없음. set() method 따로 이용해서 값을 변경해줘야 한다. set() method 작성 방법 참고
					data.set(j, temp); //j번째 element(인스턴스)를 i번째 element(인스턴스)로 바꾸는 set() method 실행.
				}
				//if (data[i] < data[j] ) {//문제가 발생 :: 객체 비교가 안된다 
				//if (data[i].compareTo(data[j])>0) {
				//if (Integer.parseInt(data[i].sno) > Integer.parseInt(data[j].sno)) {
			}
		}
	}
	
	public static void main(String[] args) {
		Comparator<Student2> compNo = new Comparator<Student2>(){
			@Override
			public int compare(Student2 s1, Student2 s2) {
				int result = Integer.parseInt(s1.sno)-Integer.parseInt(s2.sno);
				if (result == 0) {
					return s1.sname.compareTo(s2.sname);
				}
				return result;
			}
		};
		
		Comparator<Student2> compName = new Comparator<Student2>(){
			@Override
			public int compare(Student2 s1, Student2 s2) {
				int result = s1.sname.compareTo(s2.sname);
				if (result == 0) {
					return Integer.parseInt(s1.sno)-Integer.parseInt(s2.sno);
				}
				return result;
			}
		};
		
		ArrayList<Student2> al = new ArrayList<>();
		al.add(new Student2("12","홍길동"));
		al.add(new Student2("21","김동준"));
		al.add(new Student2("123","남길동"));
		al.add(new Student2("55","박동준"));

		//sortStudent(al, compName);
		//Arrays.sort(data, compName);//이게 문제가 있어서 sortStudent()를 구현
		//Collections.sort(al, compName);

		Collections.sort(al, compNo);
		
		//Collections.sort(al, (s1, s2) -> Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno));
		/*
		Arrays.sort(data, new Comparator<Student>() {

		});
		*/
		for (Student2 st: al)
			System.out.print(" " + st);
	}
}
