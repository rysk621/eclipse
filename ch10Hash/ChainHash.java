package ch10Hash;

import java.util.Scanner;

//체인법에 의한 해시
//--- 해시를 구성하는 노드 ---//
class Node {
	private int key; // 키값
	Node next; // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

	Node(int key, Node next){
		this.key = key;
		this.next = next;
	}
	
	int getKey() {
		return key;
	}
	
	public int hashCode() {
		return key * key;
	}
}

class SimpleChainHash {
	private int size; // 해시 테이블의 크기
	private Node[] table; // 해시 테이블

//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public int search(int key) {
		int hash = hashValue(key);
		Node p = table[hash];
		
		while (p != null) {
			if (p.getKey() == key) return 1;
			p = p.next;
		}
		return 0; // 검색 실패
	}

//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public int add(int key) {
		int hash = hashValue(key);
		Node p = table[hash];
		
		while (p != null) {
			if(p.getKey() == key) { // 이미 등록된 키값일 때는 return 1;
				return 1;
			}
			p = p.next; // p가 null일 때까지 p = p.next;
		}
		Node temp = new Node(key, table[hash]); // p가 null이면 key값을 갖는 node를 생성한 후 저장한다.
		table[hash] = temp;
		return 0;		
	}

//--- 키값이 key인 요소를 삭제 ---//
	public int delete(int key) {
		int hash = hashValue(key);
		Node p = table[hash];
		Node pp = null;
		
		while (p != null) {
			if (p.getKey() == key) { // key 값이 존재하면
				if (pp == null) {
					table[hash] = p.next; // table[hash]는 삭제, p.next를 연결한다.
				}
				else {
					pp.next = p.next; // 이전 Node의 next에 p node의 next를 전달
				}
				return 1; // 삭제 성공
			}
			pp = p;
			p = p.next; // 다음 노드로 이동
		}
		return 0;
	}

//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node p = table[i];
			System.out.printf("%02d", i);
			while(p != null) {
				System.out.printf(" => %s", p.getKey());
				p = p.next;
			}
			System.out.println();
		}
	}
	
	public SimpleChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		}catch(OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	public int hashValue(int key) {
		return Integer.hashCode(key) % size; // hash 설정하는 함수, 임의로 정의한다.
	}
}

public class ChainHash {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
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
	static Menu SelectMenu() {
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
		return Menu.MenuAt(key);
	}

//체인법에 의한 해시 사용 예
	public static void main(String[] args) {
		Menu menu;
		SimpleChainHash hash = new SimpleChainHash(20);
		Scanner stdIn = new Scanner(System.in);
		int select = 0, result = 0, val = 0;
		final int count = 15;
		do {
			switch (menu = SelectMenu()) {
			case Add:

				int[] input = new int[count];
				for (int ix = 0; ix < count; ix++) {
					double d = Math.random();
					input[ix] = (int) (d * 20);
					System.out.print(" " + input[ix]);
				}
				for (int i = 0; i < count; i++) {
					if ((hash.add(input[i])) != 0)
						System.out.println("Insert Duplicated data.");
				}
				break;
			case Delete:
				// Delete
				System.out.println("Delete Value:: ");
				val = stdIn.nextInt();
				result = hash.delete(val);
				if (result == 1)
					System.out.println("해당 데이터를 삭제함");
				else
					System.out.println("해당 데이터가 없음");
				System.out.println();
				break;
			case Search:
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.search(val);
				if (result == 1)
					System.out.println("검색한 데이터가 존재함");
				else
					System.out.println("해당 데이터가 없음");
				System.out.println();
				break;

			case Show:
				hash.dump();
				break;
			}
		} while (menu != Menu.Exit);
		stdIn.close();
	}
}
