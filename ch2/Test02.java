package ch2;

public class Test02 {
	
	public static void main(String[] args) {
		int depositAmount;
		depositAmount = 50000;
		boolean isMarried = true;
		char gender = 'F';
		gender = 'M';
		String greeting = "Good morning"; //참조변수 greet: ""내 문자열의 주소를 가지고 있음
		System.out.println(greeting+" "+depositAmount+"\n"+isMarried+"\t"+gender);
		
		byte num1 = 1;
		short num2 = 20;
		long num3 = 300;
		long num4 = 2147483648l;
		System.out.println(num1 + num2 + num3 + num4);
		
		// int a = 3.14; float a = 3.14; both means error -- 3.14 means double(코드에서 실수는 double이 default로 해석됨)
		double a = 3.14;
		float b = 3.1f;
		double c = 3.14f;
		
		System.out.println(a+b+c); // 실수형 default: double
	}

}