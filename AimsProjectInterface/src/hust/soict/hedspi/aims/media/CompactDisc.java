package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	
	private List<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added track: " + track.getLength());
        } else {
            System.out.println("Track " + track.getTitle() + " already exists in the list.");
        }
	}
	
	public void removeTrack(Track trackName) {
		
		for (Track trck : tracks) {
            if(trackName.equals(trck)) tracks.remove(trackName);
            else System.out.println("No track's name founded.");;
        }
	}
	
	public int getLength() {
		int trackLength = 0;
		for (Track trck : tracks) {
            trackLength = trck.getLength() + trackLength;
        }
		return trackLength;
	}

	@Override
	public void play() {
		for (Track trck : tracks) {
				System.out.println("Playing track: " + trck.getTitle());
				System.out.println("Track length: " + trck.getLength());	
		}
	}

	@Override
	public String toString() {

		return String.format("%20s%20s",artist,tracks.toString());
	}

	
	
}