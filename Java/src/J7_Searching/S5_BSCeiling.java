package J7_Searching;

public class S5_BSCeiling {
    public static void main(String[] args) {
        int[] arr={25,45,56,78,81};
        int target=83;
        System.out.println(ceililngOfNumber(arr,target));
    }
    static int ceililngOfNumber(int[] arr,int target){
        if(target>arr[arr.length-1]){
            return -1;
        }
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
        return start;   //only change from binary search
    }
}
