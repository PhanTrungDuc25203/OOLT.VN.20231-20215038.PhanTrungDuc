package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>() ;
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		for (String author : authors) {
            if(authorName.equals(author)) ;
            else authors.add(authorName);
        }	
	}
	
	public void removeAuthor(String authorName) {
		
		for (String author : authors) {
            if(authorName.equals(author)) authors.remove(authorName);
            else ;
        }
	}
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}

	
	
}
