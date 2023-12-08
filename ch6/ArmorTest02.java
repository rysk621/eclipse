package ch6;

public class ArmorTest02 {
	public void doWork() {
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
	
	public static void main(String[] args) {
		ArmorTest02 at = new ArmorTest02(); //자기 자신의 instance를 만들고 참조
		at.doWork();
	}
}
