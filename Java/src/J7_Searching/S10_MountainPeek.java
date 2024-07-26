package J7_Searching;
// 852. https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// 162.  https://leetcode.com/problems/find-peak-element/description/
public class S10_MountainPeek {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};   // ans should be Index  1,5
        System.out.println(peakIndexInMountainArray(arr));
    }
        static int peakIndexInMountainArray(int[] arr) {//bitonic arr
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > arr[mid+1]) {
                    end = mid; //mid will be part of ans
                } else {
                    start = mid + 1;  //mid+1 element > mid element
                }
            }
            return end;   //return start; is also valid
    }
}
