package Array_technics.TwoPointer;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,2,0,0,4,5,1};
        System.out.println(Arrays.toString(moveZero(arr,10)));
    }
    private static int[] moveZero(int[] a,int n) {//T-> O(n), S-> O(1)
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) return a;
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
        return a;
    }
}
