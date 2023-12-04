package hust.soict.hedspi.aims.disc.DigitalVideoDisc;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	
	
	@Override
	public String toString() {
		return String.format(super.toString());
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public void playDialog() {
		showPlayingDialog(this.getTitle(), this.getLength());
	}
	
	private static void showPlayingDialog(String songInfo, int progressBarRunTimeInSeconds) {
        JOptionPane optionPane = new JOptionPane();
        JProgressBar progressBar = new JProgressBar(0, 100);
        optionPane.setMessage(new Object[] {
                "Playing: " + songInfo,
                progressBar
        });

        // Tạo một SwingWorker để thực hiện công việc tính toán trong background
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int totalTimeSteps = 100;
                int timeIncrement = progressBarRunTimeInSeconds / totalTimeSteps;

                for (int i = 0; i <= totalTimeSteps; i++) {
                    // Cập nhật giá trị của ProgressBar
                    progressBar.setValue(i);
                    // Đếm ngược thời gian
                    int remainingTime = progressBarRunTimeInSeconds - i * timeIncrement;
                    optionPane.setMessage(new Object[] {
                            "Playing: " + songInfo,
                            "Remaining Time: " + formatTime(remainingTime),
                            progressBar
                    });
                    // Dừng 100ms giữa các bước
                    Thread.sleep(100);
                }
                return null;
            }

            //...
        };

        // Bắt đầu SwingWorker để thực hiện công việc tính toán trong background
        worker.execute();

        // Hiển thị cửa sổ dialog và đợi cho đến khi công việc kết thúc
        JOptionPane.showOptionDialog(null, optionPane, "Now Playing", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    }

    // Phương thức chuyển đổi thời gian từ giây sang định dạng phút:giây
    private static String formatTime(int seconds) {
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        long remainingSeconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
