package J8_Sorting;
import java.util.Arrays;
//SC-O(1),TC(BC:O(n-1),WC:O(n^2)) ,Stable
//Adaptive: steps get reduced if array is sorted as compare to bubble sort
//if partially sorted is is good(hybrid algorithms)
public class S3_Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
