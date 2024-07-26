package Array_technics;

import java.util.Arrays;
import java.util.Scanner;

public class pratice {
    public static void main(String[] args) {
//        int[] arr={-3,-1,23,43,54,64};
//        int target=64;
        int[] arr={68,58,43,30,15,-10,-5};
        int target=-10;
        System.out.println(binarysearch(arr,target));
    }
    static int binarysearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end- start)/2;
            if(arr[mid]==target) {
                return mid;
            }if(isAsc){
                if(arr[mid]<target){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }else{
                if(arr[mid]<target){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }
        }
        return -1;
    }
}
