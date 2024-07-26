package J6_Array;
import java.util.ArrayList;

import java.util.Arrays;

public class LeftRotateArrByK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
//        System.out.println(Arrays.toString(leftRotateArr(arr)));
//        System.out.println(Arrays.toString(leftRotateArrByK(arr,3)));
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5,6,7));
        System.out.println(rotateArrListByK(arrayList,3));
        System.out.println(Arrays.toString(leftRotateOp(arr,7,3)));
    }
    private static int[] leftRotateArr(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
        return arr;
    }
    static int[] leftRotateArrByK(int[] arr, int k){//T- O(n+k) , S-> O(d)
        int n = arr.length;
        int[] temp = new int[n-1];
        for (int i = 0; i < k; i++) {
            temp[i]=arr[i];
        }
        for (int i = k; i <n; i++) {
            arr[i-k] =arr[i];
        }
        for (int i = n-k; i <n; i++) {
            arr[i]=temp[i-(n-k)];
        }
        return arr;
    }
    public static ArrayList<Integer> rotateArrListByK(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k%n;
        ArrayList<Integer> temp = new ArrayList<>(n);
        for (int i = 0; i < k; i++) {
            temp.add(arr.get(i));
        }
        for (int i = k; i < n; i++) {
            arr.set(i - k, arr.get(i));
        }
        for (int i = n - k; i < n; i++) {
            arr.set(i, temp.get(i - (n - k)));
        }
        return arr;
    }
    // Function to Reverse the array
    static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static int[] leftRotateOp(int arr[], int n, int d) {//T- O(2n),S- O(1)
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
        return arr;
    }
}
