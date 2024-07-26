package Array_technics.TwoPointer;

import java.util.Arrays;

public class removeDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};   //sorted array
        System.out.println(DistinctCount(arr));
        for(int i :arr){
            System.out.print(i+" ");
        }
        System.out.println(Arrays.toString(arr));
    }
    private static int DistinctCount(int[] arr) {
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[j] != arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }
}
