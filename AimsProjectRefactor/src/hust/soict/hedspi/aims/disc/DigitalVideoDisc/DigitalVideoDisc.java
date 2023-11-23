package hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media{
	private String director;
	private int length;
	private static int nbDigitalVideoDisc = 0;
	
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	public static void setNbDigitalVideoDisc(int nbDigitalVideoDisc) {
		DigitalVideoDisc.nbDigitalVideoDisc = nbDigitalVideoDisc;
	}
	
	
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
		nbDigitalVideoDisc++;
	}
	
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
		nbDigitalVideoDisc++;
	}
	@Override
	public String toString() {
        return String.valueOf(id);
    }
}
