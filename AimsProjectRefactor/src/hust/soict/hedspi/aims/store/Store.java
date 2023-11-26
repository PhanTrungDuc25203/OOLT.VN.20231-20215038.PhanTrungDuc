package hust.soict.hedspi.aims.store;

import java.util.ArrayList;


import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	
	public Store() {
		super();
	}

	public void addMedia(Media med) {
		itemsInStore.add(med);
		return;
	}
	
	public void addMedia(Media med[]) {
		for( int i = 0 ; i < med.length ; i++) {
			itemsInStore.add(med[i]);
		}
	}
	
	public void removeMedia(Media med) {
		itemsInStore.remove(med);
		return;
	}
	
	public void print() {
		System.out.println("      ********************************CART****************************");
		System.out.format("%10s%30s%20s%10s","ID","TITLE","CATEGORY", "COST");
		System.out.println();
		for (Media med : itemsInStore) {
        	if (med != null) {
        		System.out.format("%10s%30s%20s%10s",med.getId(),med.getTitle(),med.getCategory(), med.getCost());
        		System.out.println();
        	}
    	}
		return;
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}


	public Media searchForItemInStore(String mediaNameToSearch) {
		for(Media med : itemsInStore) {
			if(med.getTitle().equals(mediaNameToSearch)) {
					System.out.format("%10s%30s%20s%10s%10s%10s",med.getId(),med.getTitle(),med.getCategory(), med.getCost());
					System.out.println(med.toString());
					System.out.println();
					return med;	
			} else {
				System.out.println("No item named " + mediaNameToSearch + "founded");
				return null;
			}
		}
		return null;		
	}

}
