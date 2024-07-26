package J8_Sorting;

import java.util.Arrays;//Alka sinking,exchange sort

//SC-O(1),TC(BC:O(n),WC:O(n^2))
public class S1_Bubble_Sort {
    public static void main(String[] args) {
        int[] arr ={5,4,2,3,1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
                //if you did not swap for a particular value if i,
                // it means the array is sorted hence stop the program
                if (!swapped) {
                    break;
                }
            }
        }
    }
}
