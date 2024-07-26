package J4_Patterns;
import java.util.Scanner;

public class Basic_Pattern {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        pattern6(n);
    }
    static void pattern1(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j<=n+1-i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int i = 0; i < 2*n-1; i++) {
            int totalColInRow = i>n ? 2*n-i :i;
            for (int j = 0; j < totalColInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for (int i = 0; i <2*n; i++) {
            int totalColInRow = i>n ? 2*n-i :i;
            int noOfSpace = n -totalColInRow;
            for (int s = 0; s < noOfSpace; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j <totalColInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 0; space < n-row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    static void pattern6(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            int c = row > n ? 2 * n - row: row;
            for (int space = 0; space < n-c; space++) {
                System.out.print("  ");
            }
            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    static void pattern7(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
