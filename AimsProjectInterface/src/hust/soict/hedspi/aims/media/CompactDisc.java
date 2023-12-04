package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

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
	
	@Override
	public void playDialog() {
		JOptionPane.showMessageDialog(
                null,              
                "Playing: " + this.getTitle() + this.getTracks(), 
                "Now playing",        
                JOptionPane.INFORMATION_MESSAGE 
        );
	}
	
	public void playDialog2() {
		showPlayingDialog(this.getTitle());
	}

	private static void showPlayingDialog(String songInfo) {
		
		
		int progressBarRunTimeInSeconds = 0;
        JOptionPane optionPane = new JOptionPane();
        
        JProgressBar progressBar = new JProgressBar(0, 100);
        optionPane.setMessage(new Object[]{
                "Playing: " + songInfo,
                progressBar
        });

        JButton pauseButton = new JButton("Pause");
        JButton resumeButton = new JButton("Resume");
        optionPane.setOptions(new Object[]{pauseButton, resumeButton});

        AtomicBoolean paused = new AtomicBoolean(false);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int totalTimeSteps = 100;  // Số bước cần thiết để ProgressBar đi từ 0% đến 100%
                int timeIncrement = progressBarRunTimeInSeconds / totalTimeSteps;

                for (int i = 0; i <= totalTimeSteps; i++) {
                    while (paused.get()) {
                        Thread.sleep(100);
                    }

                    progressBar.setValue(i);

                    int remainingTime = progressBarRunTimeInSeconds - i * timeIncrement;
                    optionPane.setMessage(new Object[]{
                            "Playing: " + songInfo,
                            "Remaining Time: " + formatTime(remainingTime),
                            progressBar
                    });

                    Thread.sleep(timeIncrement * 100);
                }
                return null;
            }

            @Override
            protected void done() {
                optionPane.setValue(JOptionPane.CLOSED_OPTION);
            }
        };

        worker.execute();

        pauseButton.addActionListener(e -> {
            paused.set(true);
            pauseButton.setEnabled(false);
            resumeButton.setEnabled(true);
        });

        resumeButton.addActionListener(e -> {
            paused.set(false);
            pauseButton.setEnabled(true);
            resumeButton.setEnabled(false);
        });

        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
//        optionPane.setSize(500,500);
        JDialog dialog = optionPane.createDialog("Now Playing");
        dialog.setVisible(true);
    }

    private static String formatTime(int seconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
