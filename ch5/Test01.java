package ch5;

public class Test01 {
	public static int f(int x) {
		int value;
		value = 2*x*x + 4*x + 5;
		return value;
	}
	public static void main(String[] args) {
		int y;
		y=f(2);
		System.out.println("y = "+y);
		Armor arm = new Armor();
		arm.getName();
		arm.weight = 10; // weight는 default로 선언되어 있음. Test01과 Armor는 같은 패키지 이내에 있는 클래스이므로 사용 가능. --> 다른 패키지에서 사용하려면 import를 사용하면 됨, 5장 이후에 나옵니다. 
		arm.color = "red";
		
	}
}
