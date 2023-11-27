package hust.soict.hedspi.aims.Aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;


public class Aims {
	
	public static void main(String[] args) {
		
		DigitalVideoDisc dvdList[] = {
				new DigitalVideoDisc(1004,"Lion King","Animation",59.95f,"Roger Allers",87),
				new DigitalVideoDisc(1005,"Alien Conquer","Science Fiction",222.95f,"George Lucas",78),
				new DigitalVideoDisc(1006,"Aladin","Animation",151.95f,"Group of makers",123),
				new DigitalVideoDisc(1007,"Cinderalla","Animation",20.13f,"Group of makers",200),
				new DigitalVideoDisc(1008,"Avenger: End game","Action",123.95f,"Group of makers",300),
		};
		
		
		
		List<String> authors1 = List.of("Nam Cao");
		List<String> authors2 = List.of("Dale Carnegie");
		List<String> authors3 = List.of("Jennifer Kahnweiler");
		List<String> authors4 = List.of("Nguyễn Hữu Đa");
		List<String> authors5 = List.of("Ban Hà Bằng", "Nguyễn Đức Nghĩa");
		Book bookList[] = {
				new Book(2001, "Vợ Nhặt", "Truyện ngắn", 10.00f, authors1),
				new Book(2002, "Đắc nhân tâm", "Tham khảo", 500.00f, authors2),
				new Book(2003, "Sức mạnh của sự thầm lặng", "Tham khảo", 900.00f, authors3),
				new Book(2004, "Thỏ và Rùa", "Dân gian", 6.00f, authors4),
				new Book(2005, "Lập trình C++", "Lập trình", 20.00f, authors5),
		};
		
		
		
	List<Track> trackList1 = new ArrayList<Track>();
	 	trackList1.add(new Track("Alone", 100));
	 	trackList1.add(new Track("Alone II", 200));
	 	trackList1.add(new Track("Faded", 300));
	 	trackList1.add(new Track("Unity", 400));
	 	trackList1.add(new Track("i'm on my way", 500));
	 List<Track> trackList2 = new ArrayList<Track>();
		 trackList2.add(new Track("Lover", 100));
		 trackList2.add(new Track("Hello", 200));
	 List<Track> trackList3 = new ArrayList<Track>();
	 	trackList3.add(new Track("Tàu anh qua núi", 100));
	 	trackList3.add(new Track("Sầu tím điệp hồng", 200));
	 	trackList3.add(new Track("Hồng nhan", 300));
	 List<Track> trackList4 = new ArrayList<Track>();
	 	trackList4.add(new Track("Thunder", 100));
	 	trackList4.add(new Track("My Heart", 200));
	 	trackList4.add(new Track("Waiting for love", 300));
	 	trackList4.add(new Track("The night", 400));
	CompactDisc compactDiscList[] = {
			new CompactDisc(3001, "Alan Walker", "EDM", 142.90f, "Alan Walker", trackList1),
			new CompactDisc(3002, "Taylor Swift", "Pop", 230.23f, "Taylor Swift", trackList2),
			new CompactDisc(3003, "Golden Music", "Bolero", 14.00f, "Artist1", trackList3),
			new CompactDisc(3004, "NCS", "EDM", 320.0f, "Avicii", trackList4),
	};
		
		Store store = new Store();
		
		store.addMedia(dvdList);
		store.addMedia(bookList);
		store.addMedia(compactDiscList);
		
		
		
		
		
		
		Cart cart = new Cart();
		Store.showMenu();
		Scanner scanner = new Scanner(System.in);
		String choice1 = scanner.nextLine();
		do{
			switch (choice1) {
		    case "1":                                                        				 //VIEW STORE
		        Store.storeMenu();
		        String choice2 = scanner.nextLine();
		        switch (choice2) {
		        case "1":													 				 //SEE MEDIA IN DETAILS
		    		System.out.print("Enter a Media's name: ");
		    		String mediaNameToSearch = scanner.nextLine();
		    		store.searchForItemInStore(mediaNameToSearch);
		    		Store.mediaDetailsMenu();
		    		String choice3 = scanner.nextLine();
		    		switch (choice3) {
		    		case "1":                                               				 //ADD TO CART
		    			break;
		    		case "2":																 //PLAY
		    			break;
		    		case "0":												 				 //BACK
		    			System.exit(0);
		    			break;
		    		}
		        	break;
		        case "2":																	 //ADD MEDIA TO CART
		        	store.print();
		        	System.out.print("Enter a Media's name: ");
		    		String mediaNameToAddToCart = scanner.nextLine();
		    		cart.addMedia(store.searchForItemInStore(mediaNameToAddToCart));
		    		cart.print();
		    		cart.totalQuantity();
		        	break;
		        case "3":																	 //PLAY MEDIA
		        	System.out.print("Enter a Media's name: ");
		    		String mediaNameToAddToPlay = scanner.nextLine();
		    		cart.playMedia(store.searchForItemInStore(mediaNameToAddToPlay));
		        	break;
		        case "4":																	 //SEE CURRENT CART
		        	break;
		        case "0":																	 //BACK
		        	
		        	break;
		        }
		        break;
		    case "2":																		 //UPDATE STORE
		    	String mediaNameToSearch = scanner.nextLine();
	    		
	    		if(store.searchForItemInStore(mediaNameToSearch) != null) {
	    			store.removeMedia(store.searchForItemInStore(mediaNameToSearch));
	    		} else {
	    			System.out.println("New media to Store:");
	    			System.out.println("Title: " + mediaNameToSearch);
	    			System.out.println("Media's type: ");
	    			System.out.println("ID      : ");
    				int id = scanner.nextInt();
    				System.out.println("Category: ");
    				String category = scanner.nextLine();
    				System.out.println("Cost    : ");
    				float cost = scanner.nextFloat();
	    			String mediaType = scanner.nextLine();
	    			switch (mediaType) {
	    			case "DigitalVideoDisc":
	    			case "DVD":
	    			case "DVDs":
	    				System.out.println("Director: ");
	    				String director = scanner.nextLine();
	    				System.out.println("Length  : ");
	    				int length = scanner.nextInt();
	    				DigitalVideoDisc newDVD = new DigitalVideoDisc(id, mediaNameToSearch, category, cost, director, length);
	    				store.addMedia(newDVD);
	    				break;
	    			case "CompactDisc":
	    			case "CD":
	    			case "CDs":
	    				System.out.println("Artist: ");
	    				String artist = scanner.nextLine();
	    				
	    				
	    				System.out.print("Input track's quantity: ");
	    				int numberOfTrack = scanner.nextInt();
		    			scanner.nextLine(); // Đọc dòng trống để tiêu hao dấu xuống dòng
		    			List<Track> newTrackList = new ArrayList<Track>();
		    			for (int i = 0; i < numberOfTrack; i++) {
		    			    System.out.println("Track " + (i + 1) + "'s details: ");
		    			    System.out.print("Track's title: ");
		    			    String trackTitle = scanner.nextLine();
		    			    scanner.nextLine(); // Đọc dòng trống để tiêu hao dấu xuống dòng
		    			    System.out.print("Track's length: ");
		    			    int trackLength = scanner.nextInt();		            
		    			    newTrackList.add(new Track(trackTitle,trackLength));
		    			}
	    			    
	    			    CompactDisc newCD = new CompactDisc(id, mediaNameToSearch, category, cost, artist, newTrackList);
	    			    store.addMedia(newCD);
	    				break;
	    			case "Book":
	    			case "Books":
	    				System.out.print("Input author's numbre: ");
	    				int numberOfAuthor = scanner.nextInt();
		    			scanner.nextLine();
		    			List<String> newAuthorList = new ArrayList<String>();
		    			for (int i = 0; i < numberOfAuthor; i++) {
		    			    System.out.print("Author's title: ");
		    			    String authorName = scanner.nextLine();
		    			    newAuthorList.add(authorName);
		    			}
		    			
		    			Book newBook = new Book(id, mediaNameToSearch, category, cost, newAuthorList );
		    			store.addMedia(newBook);
	    				break;
	    			}
	    			
	    		}
		        break;
		    case "3":																		 //SEE CURRENT CART
		    	cart.print();
		    	Store.cartMenu();
		    	String choice4 = scanner.nextLine();
					switch (choice4) {
					case "1":
						break;
					case "2":
						System.out.println("Sort items by: ");
						String sortChoice = scanner.nextLine();
						if(sortChoice.equals("Cost")||sortChoice.equals("cost")) {
							cart.sortByCost();
							cart.print();
						}
						if(sortChoice.equals("Title")||sortChoice.equals("title")) {
							cart.sortByTitle();
							cart.print();
						}
						break;
					case "3":
						break;
					case "4":
						break;
					case "5":
						cart.removeAllMediaInCart();
						cart.print();
						break;
					case "0":
						break;
					}
		        // code to be executed if expression matches value2
		        break;
		    case "0":																	     //EXIT
		    	System.exit(0);
		        break;
		    default:
		        System.out.println("Please choose again!");
			} 
			scanner.close();
		} while(true);
	}
}
