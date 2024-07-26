package J6_Array;

public class SecondLargestSmallest {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,5,1};
        System.out.println(secondLargest(arr));
        System.out.println(secondLargestOp(arr));
        System.out.println(secondSmallest(arr));
    }
    private static int secondSmallest(int[] arr) {
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<min){
                secondMin = min;
                min = arr[i];
            }
            else if(arr[i]<secondMin && arr[i]>min){
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
    private static int secondLargestOp(int[] arr) {
        int max = arr[0];
        int secondMax = -1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                secondMax = max;
                max = arr[i];
            }
            else if(secondMax < arr[i] && arr[i] <max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    private static int secondLargest(int[] arr) {
        int max = LargestNo(arr);
        int secondMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>secondMax && arr[i]<max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
    private static int LargestNo(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
