package ch7.exercise;

public class Test {
	public static void main(String[] args) {
		Child c1 = new Child();
		c1.setName("33");
		
		System.out.println(c1.getName());
		
		Child c2 = new Child("name1");
		System.out.println();
		System.out.println(c2.toString());
	}
}
