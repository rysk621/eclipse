package com.ruby.java.ch13.multiGen;

class Bag<T, N>{
	private T thing;
	private N name;
	
	public Bag(T thing, N name) {
		this.thing = thing;
		this.name = name;
	}
	
	public T getThing() {
		return this.thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public N getName() {
		return this.name;
	}
	
	public void setName(N name) {
		this.name = name;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
		System.out.println("N의 타입은 " + name.getClass().getName());
	}
}

class Book{
	public String toString() {
		return "책";
	}
}
class PencilCase{}
class NoteBook{}

public class BagTest {
	public static void main(String[] args) {
		Bag<Book, String> bag = new Bag<>(new Book(), "과학");
		
		bag.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is " + book);
		System.out.println("Name is " + name);

//		System.out.println("Thing's name is " + name + book);
	}
}
