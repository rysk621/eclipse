package ch6;

public class ArmorTest {
	public static void main(String[] args) {
		Armor suit1 = new Armor();
		Armor suit2 = new Armor();
		Armor suit3 = new Armor();
		
		suit1.setName("Mark6");
		suit1.setHeight(180);
		suit2.setName("Mark16");
		suit2.setHeight(220);
		suit3.setName("Mark38");
		suit3.setHeight(200);
		
		System.out.println(suit1.getName()+" : "+suit1.getHeight());
		System.out.println(suit2.getName()+" : "+suit2.getHeight());
		System.out.println(suit3.getName()+" : "+suit3.getHeight());
	}
}
