package hust.soict.hedspi.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private int qtyOrdered = 0;
	private ArrayList<Media> itemOrdered = new ArrayList<>();

	public Cart() {
		super();
	}
	
	public Cart(ArrayList<Media> itemOrdered) {
		super();
		this.itemOrdered = itemOrdered;
	}

	public int totalQuantity() {
		return qtyOrdered;
	}
	
	public void addMedia(Media med) {
		itemOrdered.add(med);
	}
    
	public void addMedia(Media med[]) {
		for( int i = 0 ; i < med.length ; i++) {
			itemOrdered.add(med[i]);
		}
	}
	
	public void removeMedia(Media med) {
		itemOrdered.remove(med);
	}
	
	public double totalCost() {
		float total = 0;
		for(Media med : itemOrdered) {
			if (med != null) {		
				total = total + med.getCost();
			}
		}
		return total;
	}
	
	
	public String search(String str) {
		if(isMatch(str) == true) {
			return "Found";
		}
		return "Not found";
	}
	
	public boolean isMatch(String str) {
		for (Media med : itemOrdered) {
        	if (med != null) {
        		if(med.getTitle().equals(str)) {
        			return true;
        		}
        	}
    	}
		return false;		
	}

	public void print(){	
		System.out.println("      ********************************CART****************************");
		System.out.format("%10s%30s%20s%10s","ID","TITLE","CATEGORY", "COST");
		System.out.println();
		for (Media med : itemOrdered) {
        	if (med != null) {
        		System.out.format("%10s%30s%20s%10s",med.getId(),med.getTitle(),med.getCategory(), med.getCost());
        		System.out.println();
        	}
    	}
		return;
	}
	
	public void sortByTitle() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCost() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public void playMedia(Media med) {
		if(med instanceof DigitalVideoDisc || med instanceof CompactDisc) {
			((DigitalVideoDisc) med).play();
		} else {
			System.out.println("Can't play this media except DVDs and CDs");
		}
	}
	
	public void removeAllMediaInCart() {
		for(Media med : itemOrdered) {
			itemOrdered.remove(med);
		}
	}
}
