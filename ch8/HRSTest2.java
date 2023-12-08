package ch8;

public class HRSTest2 {
	public static void calcTax(Employee e) {
//		if (e instanceof Salesman) {
//			System.out.println("Salesman의 참조변수입니다.");
//			System.out.println(e.annual_sales);
//		} else if (e instanceof Manager) {
//			System.out.println("Manager의 참조변수입니다.");
//			System.out.println(e.num_team);
//		} else if (e instanceof Consultant) {
//			System.out.println("Consultant의 참조변수입니다.");
//			System.out.println(e.num_project);
//		} else {
//			System.out.println("Employee의 참조변수입니다.");
//		}
	}

	public static void main(String[] args) {
		Salesman s = new Salesman();
		Manager m = new Manager();
		Consultant c = new Consultant();

		calcTax(s);
		calcTax(m);
		calcTax(c);
	}
}
