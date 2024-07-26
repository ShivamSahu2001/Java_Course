package J6_Array;

import java.util.Scanner;
import java.util.Arrays;
public class A3_twoDArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//         int[][] arr = new int[3][];
//         int[][] arr2D= {
//                 {1,2,3},
//                 {4,5},
//                 {6,7,8,9}
//         };
        int[][] arr = new int[3][3];
        System.out.println(arr.length); //row length
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = s.nextInt();

            }
        }
        // Print the 2-D arrays
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }

        // Enhanced for loop
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
