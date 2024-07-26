package Array_technics.SWindow;
//max length Sub array which is less than k
public class S2_MaxLengthSA {
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,8};
        int k = 14;
        System.out.println(maxLength(arr,k));
        System.out.println(maxLengthBetter(arr,k));
        System.out.println(maxLengthOp(arr,k));
    }
    static int maxLength(int[] arr,int k){//T-O(n^2),S-O(1)
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum<=k){
                    length = Math.max(length,j-i+1);
                }else {
                    break;
                }
            }
        }
        return length;
    }
    static int maxLengthBetter(int[] arr,int k){//T-O(n+n),S-O(1)
        int l=0, r=0,sum=0,maxLength=0;
        while(r<arr.length){
            sum += arr[r];
            while(sum>k){
                sum -=arr[l];
                l++;
            }
            if(sum<=k){
                maxLength = Math.max(maxLength,r-l+1);
            }
            r++;
        }
        return maxLength;
    }
    static int maxLengthOp(int[] arr,int k){//T-O(n),S-O(1)
        int l=0, r=0,sum=0,maxLength=0;
        while(r<arr.length){
            sum += arr[r];
            if(sum>k){
                sum -=arr[l];
                l++;
            }
            if(sum<=k){
                maxLength = Math.max(maxLength,r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}
