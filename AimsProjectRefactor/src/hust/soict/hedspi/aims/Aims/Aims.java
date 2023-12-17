package hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.test.cart.CartTest.Customer;

public class Aims {
	
	public static void main(String[] args) {
		Customer cus1 = new Customer();
		DigitalVideoDisc [] dvdList = {
	            new DigitalVideoDisc("Nhạc vàng","Music","Tong Van Vuong", 90, 10.4f),
	            new DigitalVideoDisc("King and Queen","Music","Ava Max", 120, 100.7f),
	            new DigitalVideoDisc("Faded","Music","Alan Walker", 90, 150.3f),
	            new DigitalVideoDisc("Learning JS Pro4","Programming","Tong Van Vuong", 90, 4.321f),
	            new DigitalVideoDisc("Learning JS Pro5","Programming","Tong Van Vuong", 90, 5.321f),
	            new DigitalVideoDisc("Spectre","Music","Alan Walker", 60, 200f)
	        };
		
		
		cus1.chooseDvdCheckDvd("Tom and Jerry", "Cartoon", "Joe Babera", 100, 13.4f);
		cus1.chooseDvdCheckDvd(dvdList);
		
		cus1.giveTheDiscBack(dvdList[2]);
		//System.out.println(DigitalVideoDisc.getNbDigitalVideoDisc());
	}
}
