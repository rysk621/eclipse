package ch8;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		myList.print();
		System.out.println();
		
		myList.add("JAVA");
		myList.add("JSP");
		myList.add("Servlet");
		myList.print();
	}
}
