package ch08리스트;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	// constructor
	public LinkedList1() {
		first = null;
	}

	public int delete(int element) {
//		delete the element, if 노드개수 1개인 경우 (null pointer exception 주의) else if 노드 여러 개인 경우 else element==마지막 노드의 data일 때 ###
		Node1 p = first, q = null;
		while (p != null) {
			if (p.data == element) {
				if (q == null) { // node 개수가 1개일 때
					first = first.link;
					p = null;
					return element;
				}
				q.link = p.link;
				return element;
			}
			q = p;
			p = p.link;
		}
		return -1;
	}

	public void show() { // 전체 리스트를 순서대로 출력한다. ###
		System.out.println("<Linked List>");
		Node1 temp = first;
		if (temp != null) {
			while (temp != null) {
				if (temp.link == null)
					System.out.print(temp.data);
				else
					System.out.print(temp.data + ", ");
				temp = temp.link;
			}
			System.out.println();
		} else
			System.out.println("없음");
	}

	public void add(int element) { // 임의의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 ###
		Node1 temp = new Node1(element);

		if (first == null) {
			first = temp;
		} else {
			Node1 p = first, q = null;
			while (p != null) {
				if (element < p.data) {
					if (q == null)
						first = temp;
					else
						q.link = temp;
					temp.link = p;
					return;
				} else { // element > p.data일 때
					q = p;
					p = p.link; // 한칸 옮겨간다.
					if (p == null) { // q가 마지막 노드일 때 q.link에 temp 저장
						q.link = temp;
						return;
					}
				}
			}
		}
	}

	public boolean search(int data) { // 전달한 data가 LinkedList에 존재하는지 판정 ###
		Node1 temp = first;
		while (temp != null) {
			if (temp.data == data)
				return true;
			temp = temp.link;
		}
		return false;
	}
}

public class IntLinkedList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private String message; // 표시할 문자열

		static Menu menuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu selectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.menuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		do {
			switch (menu = selectMenu()) { // enum Menu 생성
			case Add:
				data = rand.nextInt(20);
				double d = Math.random();
				data = (int) (d * 50);
				l.add(data);
				System.out.println("data inserted");
				break;
			case Delete:
				if (l.first == null) {
					System.out.println("list is empty.");
					break;
				}
				l.show();
				System.out.print("삭제할 데이터 : ");
				data = sc.nextInt();
				int num = l.delete(data);
				if (num == -1)
					System.out.println("no such data");
				else
					System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 노드 출력
				l.show();
				break;
			case Search: // 회원 번호 검색
				if (l.first == null) {
					System.out.println("list is empty.");
					break;
				}
				l.show();
				System.out.println("검색할 데이터 : ");
				int n = sc.nextInt();
				boolean result = l.search(n);
				if (!result)
					System.out.println(n + " 값은 존재하지 않습니다.");
				else
					System.out.println("검색한 " + n + " 데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
		sc.close();
	}
}
