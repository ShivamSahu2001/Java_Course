package Array_technics.SWindow;

public class S3_MaxPointLR {
    public static void main(String[] args) {
        int[] arr = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        System.out.println(maxPoint(arr,k));
    }
    static int maxPoint(int[] arr, int k) {//T-O(2K),S-O(1)
        int lSum=0,rSum=0,maxSum=0;
        for (int i = 0; i < k; i++) {
            lSum +=arr[i];
        }
        maxSum = lSum;
        int rIndex = arr.length -1;
        for (int i = k-1; i >=0; i--) {
            lSum -= arr[i];
            rSum += arr[rIndex];
            rIndex--;
            maxSum = Math.max(maxSum,lSum+rSum);
        }
        return maxSum;
    }
}
