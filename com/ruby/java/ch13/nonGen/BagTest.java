package com.ruby.java.ch13.nonGen;

class Bag{
	private Object thing;
	
	public Bag(Object thing) {
		this.thing = thing;
	}
	
	public Object getThing() {
		return thing;
	}
	
	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
	
}

class Book{}
class PencilCase{}
class Notebook{}

public class BagTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Bag bag = new Bag(new Book());
		Bag bag2 = new Bag(new PencilCase());
		Bag bag3 = new Bag(new Notebook());
		
		Book book = (Book) bag.getThing();
//		Book book2 = bag.getThing(); // 35행에서 (Book) caster 제거 --> error: Object type을 Book type으로 casting 해야함
		PencilCase pc = (PencilCase) bag2.getThing();
		Notebook nb = (Notebook) bag3.getThing();
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag = bag2; //같은 bag 객체끼리 비교해서 error 생기지 않지만 각각 Book, PencilCase type... type checking시에는 논리적 오류가 되므로 주의 --> generic 사용 필요
	}
}
