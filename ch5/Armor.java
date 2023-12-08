package ch5;

public class Armor {
	// 필드
	private String name;
	int height;
	int weight; // default: 접근제한자(access modifier)를 기술하지 않음
	public String color;
	protected boolean isFly;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 메소드
	void takeOff() {
		System.out.println(name); // name 변수는 (필드 선언시 private 접근제한자 사용했으므로) 해당 클래스 안에서는 사용 가능. 외부(다른 클래스)에서는 접근할 수
									// 없다. (ex. class Test01의 arm.name)
	}

	void land() {
	}

	void shootLaser() {
	}

	void launchMissile() {
	}

}
