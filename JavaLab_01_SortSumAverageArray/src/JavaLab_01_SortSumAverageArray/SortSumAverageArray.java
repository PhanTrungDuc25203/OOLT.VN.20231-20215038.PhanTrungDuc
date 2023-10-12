package JavaLab_01_SortSumAverageArray;
import java.util.Scanner;
public class SortSumAverageArray {
	public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int [] arr = new int [n];
        int sum=0;
        double average=0;
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        sortASC(arr);
        System.out.println("Dãy số được sắp xếp tăng dần: ");
        show(arr);
        sum = sumArray(arr);
        System.out.print("Tổng của dãy: " + sum);
        average = sum/(n+1);
        System.out.print("TBC của dãy: " + average);
    }

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static int sumArray(int [] arr) {
    	int tempsum=0;
    	for(int i = 0; i < arr.length; i++) {
    		tempsum+=arr[i];
    	}
    	return tempsum;
    }

    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
