package J8_Sorting;

import java.util.Arrays;

//SC-O(1),TC(BC:O(n^2),WC:O(n^2))
public class S2_Selection_Sort {
    public static void main(String[] args) {
        int[] arr={3,1,5,4,2};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last =arr.length-i-1;
            int maxindex =getMaxindex(arr,0,last);
            swap(arr,maxindex,last);
        }
    }
    static void swap (int[] arr,int first ,int second){
        int temp = arr[first];
        arr[first] =arr[second];
        arr[second]=temp;
    }
    static int getMaxindex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]){
                max =i;
            }
        }
        return max;
    }
}
