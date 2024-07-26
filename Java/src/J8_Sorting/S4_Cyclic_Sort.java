package J8_Sorting;

import java.util.Arrays;

//Apply when range given (1-N)
public class S4_Cyclic_Sort {
    public static void main(String[] args) {
        //int[] arr = {4,5,10,3,1,2,6,7,9,8};
        int[] arr ={5,4,3,2,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correct = arr[i] -1;
            if(arr[i] != arr[correct]){
                swap(arr,i, correct);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr,int i, int correct){
        int temp = arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}
