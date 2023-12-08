package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid>{
	private T thing;
	private String owner;
	
	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return this.thing;
	}
	
	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
	
	boolean isSameOwner(Bag<?> obj) {
		if(this.owner == (obj.getOwner())) return true; //equals 함수 사용 (not ==; ==는 hashcode 비교하는 연산자이고 객체가 가진 문자열이 같은지는 비교하지 않음)
		return false;
	}
}

class Solid{}
class Liquid{}

class Book extends Solid{}
class PencilCase extends Solid{}
class Notebook extends Solid{}

class Water extends Liquid{}
class Coffee extends Liquid{}

public class BagTest {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag.setOwner("KSJ");
		bag2.setOwner("KSJ");
		bag.isSameOwner(bag2);
		
		boolean result = bag.isSameOwner(bag2);
		if(result) System.out.println("소유자가 동일합니다.");
		else System.out.println("소유자가 다릅니다.");
		
//		Bag<Water> bag4 = new Bag<>(new Water());
//		Bag<Coffee> bag5 = new Bag<>(new Coffee());
		
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");
		System.out.println(s1 == s2); //true: hashcode 비교, 같은 string을 가리키고 있으므로 동일함
		System.out.println(s1 == s3); //false: hashcode 다름(다른 객체이므로)
		
		if (s1.compareTo(s3)==0) System.out.println("OK"); //compareTo method...
		System.out.println(s1.equals(s3)); //true: 객체 안의 문자열 서로 비교, 같으므로 true return
		
		String s4 = "hola";
		if(s1.compareTo(s4)<0) System.out.println("OK"); //s1과 s4의 길이 비교, 5>4이므로 true, print OK
		
	}
}
