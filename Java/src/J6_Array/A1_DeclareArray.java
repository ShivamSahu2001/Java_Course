package J6_Array;

import java.util.Arrays;
import java.util.Scanner;

public class A1_DeclareArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Array of primitive-int,char,boolean,float
//        int[] ros; // declartion of array,ros is getting defined in the stack
//        ros = new int[5]; // actually here object is being created in the memory (heap)
//        System.out.println(ros[1]);    0

        int[] arr = new int[5];
        for(int i= 0; i< arr.length; i++){
            arr[i] = s.nextInt();
        }
        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        for(int i= 0; i< arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        // Enhanced for loop
        for(int j : arr){   // for every element in array, print the element
            System.out.print(j + " ");  // here num represents element of the array
        }

        //Array of Non primitive-Store in heap memory
        String[] str = new String[4];
        for (int i =0; i<str.length;i++){
            str[i] = s.next();
        }
        String str1 = "Shivam Sahu";
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(str1.toCharArray()));
        for(String element : str){
            System.out.print(element+" ");
        }


    }
}
