	
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	
	
	private int id;
	private static int nbDigitalVideoDisc = 0;
	
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	public static void setNbDigitalVideoDisc(int nbDigitalVideoDisc) {
		DigitalVideoDisc.nbDigitalVideoDisc = nbDigitalVideoDisc;
	}
	
	
	public DigitalVideoDisc() {
		super();
	}
	
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
	}
	
	
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc++;
	}
}
