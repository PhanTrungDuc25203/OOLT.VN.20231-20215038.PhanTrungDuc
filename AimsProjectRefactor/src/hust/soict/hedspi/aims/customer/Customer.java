package hust.soict.hedspi.aims.customer;

import java.util.Scanner;

import hust.soict.hedspi.aims.store.Store;

public class Customer {
	private String name;

	public Customer() {
		super();
	}
	
	public String customerSeeAMediaDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a Media's name: ");
		String mediaNameToSearch = scanner.nextLine();
		
		return mediaNameToSearch;
	}
}
