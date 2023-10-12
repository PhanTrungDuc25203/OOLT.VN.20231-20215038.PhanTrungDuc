package Java_lab_01_JavaMatrices;
import java.util.Scanner;
//khi nhập ma trận, nhập hết phần tử hàng trước rồi sẽ tới hàng tiếp theo
public class MatricesSum {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Số hàng cảu ma trận : "); 
       int hang = scanner.nextInt();
       System.out.println("Số cột của ma trận : ");
       int cot = scanner.nextInt();
       int[][] matrix1 = new int[hang][cot];
       int[][] matrix2 = new int[hang][cot];

       System.out.println("Nhập vào từng phần tử của Matrix1 :");
       for (int i = 0; i < hang; i++) {
              for (int j = 0; j < cot; j++) {
                    matrix1[i][j] = scanner.nextInt();
              }
       }
       System.out.println("Nhập vào từng phần tử của Matrix2 :");
       for (int i = 0; i < hang; i++) {
              for (int j = 0; j < cot; j++) {
                    matrix2[i][j] = scanner.nextInt();
              }
       }

       //addition of matrices.
       int[][] resultMatix = new int[hang][cot];
       for (int i = 0; i < hang; i++) {
              for (int j = 0; j < cot; j++) {
                    resultMatix[i][j] = matrix1[i][j] + matrix2[i][j];
              }
       }

       System.out.println("\nMatrix 1 : ");
       for (int i = 0; i < hang; i++) {
              for (int j = 0; j < cot; j++) {
                    System.out.print(matrix1[i][j] + " ");
              }
              System.out.println();
       }
 
           System.out.println("\nMatrix 2 : ");
           for (int i = 0; i < hang; i++) {
                  for (int j = 0; j < cot; j++) {
                        System.out.print(matrix2[i][j] + " ");
                  }
                  System.out.println();
           }
 
           System.out.println("\nThe sum of the two matrices is : ");
           for (int i = 0; i < hang; i++) {
                  for (int j = 0; j < cot; j++) {
                        System.out.print(resultMatix[i][j] + " ");
                  }
                  System.out.println();
           }
    }
    
}