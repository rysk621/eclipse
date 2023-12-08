package ch6;

public class ArmorTest01 {
	public static void main(String[] args) {
		Armor iron1 = new Armor();
		Armor iron2 = new Armor();
		Armor iron3 = new Armor();
		
		iron1.setName("Friday");
		iron1.setHeight(190);
		
		iron2.setName("Saturday");
		iron2.setHeight(200);
		
		iron3.setName("Sunday");
		iron3.setHeight(210);
		
		System.out.println(iron1.getName()+" : "+iron1.getHeight());
		System.out.println(iron2.getName()+" : "+iron2.getHeight());
		System.out.println(iron3.getName()+" : "+iron3.getHeight());
		
	}
}
