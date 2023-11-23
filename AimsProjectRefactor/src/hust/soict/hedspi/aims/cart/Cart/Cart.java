package hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 30;
	private int qtyOrdered = 0;
	private double total = 0;
	private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if( qtyOrdered < MAX_NUMBERS_ORDERED ) {
			itemOrdered[qtyOrdered] = disc;
			disc.setId(qtyOrdered+1);
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has been added!");
		} else {
			System.out.println("The Cart is almost full!");
		}
		return;
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemOrdered[qtyOrdered] = dvd;
            	dvd.setId(qtyOrdered+1);
                qtyOrdered++;
                System.out.println("The disc " + dvd.getTitle() + " has been added!");
            } else {
            	System.out.println("The Cart is almost full!");
            }
        }
		return;
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
		if( qtyOrdered < (MAX_NUMBERS_ORDERED - 1 )) {
			itemOrdered[qtyOrdered] = dvd1;
			dvd1.setId(qtyOrdered+1);
			qtyOrdered++;
			itemOrdered[qtyOrdered] = dvd2;
			dvd2.setId(qtyOrdered+1);
			qtyOrdered++;
			System.out.println("The disc " + dvd1.getTitle() + " and " + dvd2.getTitle() + " has been added!");
		} else {
			System.out.println("The Cart is almost full!");
		}
		return;
	}
	
	
	public int totalQuantity() {
		return qtyOrdered;
	}
	
	
	public void OrderInfo(){	
		System.out.println("        ****************************************CART************************************************");
		System.out.format("%10s%30s%20s%20s%10s%10s","ID","TITLE","CATEGORY", "DIRECTOR", "LENGTH", "COST");
		System.out.println();
		for (DigitalVideoDisc disc : itemOrdered) {
        	if (disc != null) {
        		System.out.format("%10s%30s%20s%20s%10s%10s",disc.getId(),disc.getTitle(),disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
        		System.out.println();
        	}
    	}
		return;
	}
	
	public void print(){	
		System.out.println("        ****************************************CART************************************************");
		System.out.format("%10s%30s%20s%20s%10s%10s","ID","TITLE","CATEGORY", "DIRECTOR", "LENGTH", "COST");
		System.out.println();
		for (DigitalVideoDisc disc : itemOrdered) {
        	if (disc != null) {
        		System.out.format("%10s%30s%20s%20s%10s%10s",disc.getId(),disc.getTitle(),disc.getCategory(), disc.getDirector(), disc.getLength(), disc.getCost());
        		System.out.println();
        	}
    	}
		return;
	}
	
	
	public double totalCost() {
		total = 0;
		for(DigitalVideoDisc disc : itemOrdered) {
			if (disc != null) {		
				total = total + disc.getCost();
			}
		}
		return total;
	}
	
	
	public DigitalVideoDisc removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if(itemOrdered[i] == disc) {
				itemOrdered[i] = null;
				qtyOrdered--;
				total = total - disc.getCost();
				System.out.println("Remove succesfully!");
			}
		}
		return disc;
	}
	


	public String search(String str) {
		// TODO Auto-generated method stub
		if(isMatch(str) == true) {
			//System.out.format("Found");
			return "Found";
		}
		return "Not found";
	}
	
	public boolean isMatch(String str) {
		for (DigitalVideoDisc disc : itemOrdered) {
        	if (disc != null) {
        		if(disc.getTitle().equals(str)) {
        			return true;
        		}
        	}
    	}
		return false;		
	}

}
