package J6_Array;

public class A4_Max {
    public static void main(String[] args) {
        int[] arr={1,5,49,494,49};
        System.out.println(max(arr));
        System.out.println(maxRange(arr,1,3));
        int[][] arr1={{44,49,490},{494,49},{44,49,49}};
        System.out.println(max2D(arr1));
    }
    static int maxRange(int[] arr,int start,int end ){
        int maxVal =arr[start];
        for (int i = start; i <= end; i++) {
            if(arr[i]>maxVal){
                maxVal=arr[i];
            }
        }
        return maxVal;
    }
    static int max(int[]arr){
        int maxVal =arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxVal){
                maxVal=arr[i];
            }
        }
        return maxVal;
    }
    static int max2D(int[][] arr1){
        int maxVal=Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if(arr1[i][j] >maxVal){
                    maxVal=arr1[i][j];
                }
            }
        }
        return maxVal;
    }
}
