package ch7.exercise;

public class Parent {
	private String nameP;
	
	public Parent() {
		this.nameP = "-";
		System.out.println("Parent("+nameP+")");
	}
	
	public Parent(String name) {
		this.nameP = name;
		System.out.println(name);
	}
	
	public void setName(String name) {
		this.nameP = name;
	}
	
	public String getName() {
		return nameP;
	}

}
