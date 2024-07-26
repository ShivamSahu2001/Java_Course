package J7_Searching;

import java.util.Arrays;

public class S2_LinearSerach2D {
    public static void main(String[] args) {
        int[][] arr ={{3,4,5},{4,3,6,4},{23,35,456,454},{55,22}};
        int target=35;
        System.out.println(Arrays.toString(search(arr,target)));

    }
    static int[] search(int[][] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                 if(arr[i][j] ==target){
                     return new int[]{i,j}; //return array
                 }
            }
        }return new int[]{-1,-1};
    }
}
