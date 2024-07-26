package Array_technics.SWindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class S5_ConseOnesAtmostk0 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(ConseOnesBrute(arr,k));
        System.out.println(ConsOnesBetter(arr,k));
    }
    static int ConseOnesBrute(int[] arr, int k) {//T-O(n^2),S-O(1)
        int maxLength=0;
        for (int i = 0; i < arr.length; i++) {
            int countZero=0;
            for (int j = i; j < arr.length; j++) {
                if(arr[j]==0){
                    countZero ++;
                }
                if(countZero <= k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLength;
    }//1,1,1,0,0,0,1,1,1,1,0,
    static int ConsOnesBetter(int[] arr, int k) {
        int l=0,r=0,maxLength=0;
        int countZero=0;
        while(r < arr.length){
            if(arr[r]==0){
                countZero ++;
            }
            if(countZero <= k){
                maxLength = Math.max(maxLength,r-l+1);
//            }if(countZero>k) {   //something wrong
//                l = r;
//                countZero = 0;
            }if(countZero>k){
                if(arr[l]==0) countZero--;
                l++;
//            }while(countZero>k){    //this while loop take extra n time
//                if(arr[l]==0) countZero--;
//                l++;
            }
            r++;
        }
        return maxLength;
    }
}
