
public class Customer {
	

	public  Cart anOrder = new Cart();
	
	
	public void chooseDvdCheckDvd(String dvdName, String category, String director, int length, float cost) {	
		DigitalVideoDisc dvd = new DigitalVideoDisc(dvdName, category, director, length, cost);
		anOrder.addDigitalVideoDisc(dvd);
		anOrder.OrderInfo();
		System.out.format("%90s%10.6s", "Total cost: ", anOrder.totalCost());
		System.out.println();
	}
	
	
	public void chooseDvdCheckDvd(DigitalVideoDisc [] list) {
		anOrder.addDigitalVideoDisc(list);
		anOrder.OrderInfo();
		System.out.format("%90s%10.6s", "Total cost: ", anOrder.totalCost());
		System.out.println();
	}
	
	
	public void chooseDvdCheckDvd(DigitalVideoDisc dvd_1, DigitalVideoDisc dvd_2) {
		anOrder.addDigitalVideoDisc(dvd_1);
		anOrder.addDigitalVideoDisc(dvd_2);
		anOrder.OrderInfo();
		System.out.format("%90s%10.6s", "Total cost: ", anOrder.totalCost());
		System.out.println();
	}
	
	
	public void giveTheDiscBack(DigitalVideoDisc dvd) {
		anOrder.removeDigitalVideoDisc(dvd);
		anOrder.OrderInfo();
		System.out.format("%90s%10.6s", "Total cost: ", anOrder.totalCost());
		System.out.println();
	}
}
