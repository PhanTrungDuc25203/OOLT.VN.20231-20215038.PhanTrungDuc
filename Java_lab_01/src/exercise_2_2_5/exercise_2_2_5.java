package exercise_2_2_5;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class exercise_2_2_5 {
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
        String strNum1, strNum2;
        String strNotification = "You're just entered: ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input:",JOptionPane.INFORMATION_MESSAGE);
        //strNotification+=strNum1 + "and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input:",JOptionPane.INFORMATION_MESSAGE);
        //strNotification +=strNum2;
        double a = Double.parseDouble(strNum1);
        double b = Double.parseDouble(strNum2);
        double tong = a + b;
        double hieu = a - b;
        double tich = a * b;
        double thuong = (double) a / b;
        strNotification = "Tong: " + tong + ", hieu: " + hieu + ", tich: " + tich + ", thuong: " + thuong;
        JOptionPane.showMessageDialog(null, strNotification, "Show 2 numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
	}
}
