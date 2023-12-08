package ch6;

public class Member {
	
	private String name;
	private int age;
//	private String hobby;

	public Member() { //기본 생성자
		System.out.println("멤버 기본 생성자가 호출되었습니다.");
	}
	public Member(String name) { //String type parameter 하나를 가지는 생성자
		System.out.println("멤버 생성자1이 호출되었습니다.");
	}
//	public Member(String hobby) {
//		System.out.println("멤버 생성자1이 호출되었습니다.");
//	}
	public Member(int age) {
		System.out.println("멤버 생성자2가 호출되었습니다.");
	}
	public Member(String name, int age) {
		System.out.println("멤버 생성자3이 호출되었습니다.");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public String getHobby() {
//		return hobby;
//	}
//	public void setHobby(String hobby) {
//		this.hobby = hobby;
//	}
	public static void main(String[] args) {
		Member m1 = new Member(); //맨 위의 public Member(){}의 Member와 동일; 생성자를 호출하는 것
		Member m2 = new Member("홍");
		Member m3 = new Member(20);
		Member m4 = new Member("Lee", 10);
	}

}
