package ch07ex01;

public class Result {
	public static void main(String[] args) {

		Sedan sed = new Sedan();
		Suv suv = new Suv();
		Wagon wag = new Wagon();
		Truck trk = new Truck();

		sed.setName("Sedan");
		sed.setFuel("diesel");
		sed.setTire(4);
		sed.setHeight(1.6);
		
		suv.setName("SUV");
		suv.setFuel("diesel");
		suv.setTire(4);
		suv.setHeight(2);
		
		wag.setName("Wagon");
		wag.setFuel("gasoline");
		wag.setTire(4);
		wag.setHeight(2);
		
		trk.setName("Truck");
		trk.setFuel("gasoline");
		trk.setTire(4);
		trk.setHeight(2.2);
		
		System.out.println(sed.toString());
		System.out.println(suv.toString());
		System.out.println(wag.toString());
		System.out.println(trk.toString());

	}
}
