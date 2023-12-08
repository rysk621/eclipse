package ch8;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();

	public abstract void calcBonus();
}

class Salesman extends Employee {
	int annual_sales;
	
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	int num_project;
	
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}

}

class Manager extends Employee {
	int num_team;
	
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}

	@Override
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급 * 12 * 6");
	}
}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}

	@Override
	public String toString() {
		return "dir: " + super.toString();
	}
}

public class HRSTest {
	public static void calcTax(Employee e) {
		System.out.println("소득세를 계산합니다.");
	}

	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();

//		s.calcBonus();
//		c.calcBonus();
//		d.calcBonus();

//		calcTax(s);
//		calcTax(c);
//		calcTax(d);

		System.out.println(s.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println();

//		Salesman s2 = s;
//		System.out.println(s2.toString());
//
//		if (s.equals(s2)) {
//			System.out.println("동일한 객체입니다.");
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}

//		Salesman s3 = new Salesman();
//		Employee e3 = new Salesman(); //다형성 설명.

//		Salesman s4 = (Salesman)e3; //type casting 해도 자식 클래스에만 있는 필드/메서드 이용할 수는 없음.(다형성)

		Salesman s1 = new Salesman();
		Employee s2 = new Salesman();
		Object s3 = new Salesman();

		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
//		Director m4 = new Manager(); //자손 타입으로 선언된 참조변수에는 부모의 주소를 저장할 수 없습니다. (Back to the future처럼)

		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}