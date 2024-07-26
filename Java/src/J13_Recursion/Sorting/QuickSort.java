package J13_Recursion.Sorting;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,4,5,6,8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println(isPowerOfTwo(16));
    }
    static boolean isPowerOfTwo(int n) {
        if(n ==1){
            return true;
        }
        if(n%2==0){
            return isPowerOfTwo(n/2);
        }
        return false;
    }

    static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, high);
    }
}