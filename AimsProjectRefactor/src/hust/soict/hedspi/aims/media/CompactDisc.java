package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	
	private List<String> tracks = new ArrayList<String>();

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CompactDisc(int id, String title, String category, float cost, String artist, List<String> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(String trackName) {
		if (!tracks.contains(trackName)) {
            tracks.add(trackName);
            System.out.println("Added track: " + trackName);
        } else {
            System.out.println("Track " + trackName + " already exists in the list.");
        }
	}
	
	public void removeTrack(String trackName) {
		
		for (String trck : tracks) {
            if(trackName.equals(trck)) tracks.remove(trackName);
            else System.out.println("No track's name founded.");;
        }
	}
	
	public int getLength() {
		int trackLength = 0;
		for (String trck : tracks) {
            trackLength = trck.length() + trackLength;
        }
		return trackLength;
	}

	@Override
	public void play() {
		for (String trck : tracks) {
			System.out.println("Playing DVD: " + trck);
			System.out.println("DVD length: " + trck);	
        }
		
	}
	
}
