package JavaLab_01_triangle;
import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int hight1, k = 0;
	    System.out.printf("\n\nTriangle height: ");
	    hight1 = sc.nextInt();
	    for (int i = 1; i <= hight1; ++i, k = 0) {
	    	for (int space = 1; space <= hight1 - i; ++space) {
	    		System.out.print("  ");
	    	}
	    	while (k != 2 * i - 1) {
	    		System.out.print("* ");
	    		++k;
	    	}
	    	System.out.println();
	    }
	    int hight2;
	    System.out.printf("\n\nNhập vào chiều cao của kim tự tháp: ");
	    hight2 = sc.nextInt();
	    for(int i = hight2; i >= 1; --i) {
	      for(int space = 1; space <= hight2 - i; ++space) {
	        System.out.print("  ");
	      }
	      for(int j=i; j <= 2 * i - 1; ++j) {
	        System.out.print("* ");
	      }
	      for(int j = 0; j < i - 1; ++j) {
	        System.out.print("* ");
	      }
	      System.out.println();
	    }
	}
}
