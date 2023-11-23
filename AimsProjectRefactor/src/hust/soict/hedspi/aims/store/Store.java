package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc [] itemsInStore = new DigitalVideoDisc[10000];
	private int items = 0;
	
	public void addDVD(DigitalVideoDisc disc) {		
		itemsInStore[items] = disc;
		items++;
		System.out.println("The disc " + disc.getTitle() + " has been added to the Store!");
		return;
	}
	
	public DigitalVideoDisc removeDVD(DigitalVideoDisc disc) {
		for(int i = 0; i < items; i++) {
			if(itemsInStore[i] == disc) {
				itemsInStore[i] = null;
				items--;
				System.out.println("Remove from the Store succesfully!");
			}
		}
		return disc;
	}
}
