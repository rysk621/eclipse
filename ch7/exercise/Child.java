package ch7.exercise;

public class Child extends Parent {

	public Child() {
		System.out.println("Child()");
	}
	public Child(String name) {
		super(name);
		System.out.println("name2");
	}
	
	@Override
	public String toString() {
		return super.getName();
	}

}
