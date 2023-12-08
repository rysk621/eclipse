package edu;

public class MyLinkedList {

	private Node head = null; //Node type의 private 변수 head를 선언 및 초기화.
	
	// inner class
	private class Node { //private inner class인 Node를 선언
		private String data; //Node class의 필드(멤버 변수). private으로 선언되어 있음
		private Node prev;
		private Node next;

		public Node(String data) { // Node 생성자, String type의 변수 data를 받아서 Node class의 멤버 변수인 private String data에 전달(this.data)
			this.data = data;
		}
	}

	public void add(String data) { // add method: class MyLinkedTest의 instance method
		Node newNode = new Node(data); // new 명령문 이용하여 String data 매개변수로 전달받는 instance newNode를 heap memory에 생성.
		if (head == null) { //outer class의 필드인 node type 참조변수 head, null로 초기화되어있음.
			head = newNode; //참조변수 head에 참조변수 newNode를 전달. method 종료.
		} else { // head에 이미 node가 설정되어 있음(head!=null). 최소 1개 이상의 node가 list에 존재한다는 의미
			// 시작 node값을 임시 변수 temp에 설정
			Node temp = head;
			while (temp.next != null) { // 현재 node인 temp에 연결된 다음 node가 있는 동안 반복함. 
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp; // 양방향 linked list 만들기 위해서 추가된 라인
			// 29행까지 오면 list의 마지막 node에 도착했다는 의미.
		}
	}

	// 현재까지 입력된 list를 콘솔 화면에 출력한다.
	public void print() {
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
			return;
		} //else { : else 삭제하고 if문을 return;으로 닫아도 됨.
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node temp = head;
			while (true) { //반복문이니까 JAVA, JSP, servlet 각각의 data 입력받는 Node 생성
				System.out.println(temp.data); //각각의 data에 대하여 println 실행, Servlet 도달시 temp.next==null이므로 while문 break.
				if (temp.next == null)
					break;
				temp = temp.next; //temp.next==null인 경우 break 하여 수행하지 않음.
			}
			System.out.println("\n"+"-".repeat(30));
			// 현재 node인 temp가 null이 아닌 동안 while문 반복
			while (temp != null) {
				System.out.println(temp.data); //37행에 선언한 Node type 변수 next에 대하여 next.data 출력. JAVA 도달시 temp.prev==null이므로 while문 break.
				temp = temp.prev;
			}
		//}

	}
} // 해보기: 주석만 남기고 코드는 삭제 --> 재작성