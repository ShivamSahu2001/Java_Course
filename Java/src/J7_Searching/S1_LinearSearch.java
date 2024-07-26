package J7_Searching;

import java.util.Scanner;

public class S1_LinearSearch {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int[] arr={449,94,494,494,49};
        int target=4789;
        System.out.println(linearsearch(arr,target));
//        String str="Shivam";
//        char element='v';
//        System.out.println(searchString(str,element));
    }
    static int linearsearch(int[] arr,int target){
        if(arr.length==0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    static int searchString(String str,char element){
        if(str.length()==0){
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==element) return i;
        }
        return -1;
    }
}
