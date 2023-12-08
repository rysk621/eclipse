package ch7;

public class Student extends Person {
	private String major;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public Student() {
		System.out.println("Student 생성자 실행");
	}
}
