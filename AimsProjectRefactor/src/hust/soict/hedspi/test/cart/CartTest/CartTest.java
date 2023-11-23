package hust.soict.hedspi.test.cart.CartTest;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class CartTest {
	public static void main(String args[]) {
		Cart cart = new Cart();
		DigitalVideoDisc testdvd1 = new DigitalVideoDisc("Lion King","Animation","Roger Allers",87,19.95f);
		cart.addDigitalVideoDisc(testdvd1);
		
		DigitalVideoDisc testdvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		cart.addDigitalVideoDisc(testdvd2);
		
		DigitalVideoDisc testdvd3 = new DigitalVideoDisc("Aladin","Animation",19.95f);
		cart.addDigitalVideoDisc(testdvd3);
		
		cart.print();
		
		System.out.println("Aladins: " + cart.search("Aladins"));
		System.out.println("Star Wars: " + cart.search("Star Wars"));
	}
}
