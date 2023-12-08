package ch7;

public class Employee extends Person {
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {

		return super.toString() + " : " + dept + " 부서에서 근무중입니다.";
	}
	
	public Employee() {
		System.out.println("Employee 생성자 실행");
	}
}
