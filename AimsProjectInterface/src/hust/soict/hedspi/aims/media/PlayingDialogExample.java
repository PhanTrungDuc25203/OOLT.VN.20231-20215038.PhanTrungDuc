package hust.soict.hedspi.aims.media;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.util.concurrent.TimeUnit;

public class PlayingDialogExample {
    public static void main(String[] args) {
        // Giả sử bạn có thông tin về bài hát đang chơi và thời gian chạy ProgressBar
        String songInfo = "Alan Walker - Alone";
        int progressBarRunTimeInSeconds = 10;

        // Hiển thị cửa sổ dialog với thông tin về việc chơi nhạc và thanh ProgressBar
        showPlayingDialog(songInfo, progressBarRunTimeInSeconds);
    }

    // Phương thức hiển thị cửa sổ dialog với thông tin về việc chơi nhạc và thanh ProgressBar
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
                for (int i = 0; i <= 100; i++) {
                    // Cập nhật giá trị của ProgressBar
                    progressBar.setValue(i);
                    // Đếm ngược thời gian
                    int remainingTime = progressBarRunTimeInSeconds - i * progressBarRunTimeInSeconds / 100;
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

            @Override
            protected void done() {
                // Khi công việc kết thúc, đóng cửa sổ dialog
                optionPane.setValue(JOptionPane.OK_OPTION);
            }
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
