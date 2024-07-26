package J7_Searching;

public class S4_BSOrderAgnostic {
    public static void main(String[] args) {
        //int[] arr={-3,-1,23,43,54,64};
        int[] arr={68,58,43,30,15,-10,-5};
        int target=-10;
        System.out.println(orderAgnostic(arr,target));
    }
    static int orderAgnostic(int[] arr,int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc=arr[start]<arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(target== arr[mid]){
                return mid;
            }
            if(isAsc){
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                }
            }else{
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
