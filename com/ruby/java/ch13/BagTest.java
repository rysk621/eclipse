package com.ruby.java.ch13;

class Bag<T>{
	private T thing;
	
	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return this.thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName() + ", \tsuperclass는 " + super.getClass());
	}
}

class Book {}
class PencilCase {}
class Notebook {}

public class BagTest {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
//		bag = bag2; : error. Bag<Book>과 Bag<Pencil>이므로 직접 비교 불가
		System.out.println(bag.equals(bag2)); //bag:Bag<Book> type 참조변수 != bag2:Bag<PencilCase> type 참조변수
		System.out.println(bag.equals(bag3));
	}
}
