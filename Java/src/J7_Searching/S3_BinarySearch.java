package J7_Searching;

public class S3_BinarySearch {
    public static void main(String[] args) {
        int[] arr={-3,-1,23,43,54,64};
        int target=63;
        System.out.println(binarysearch(arr,target));
    }
    static int binarysearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid =start +(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
         }
        return -1;
    }
}
