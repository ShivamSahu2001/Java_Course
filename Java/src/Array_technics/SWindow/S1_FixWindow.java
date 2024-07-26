package Array_technics.SWindow;
import java.util.Arrays;
public class S1_FixWindow {
    public static void main(String[] args) {
        int[] arr ={2,1,6,7,8};
//        int[] arr1 = {2,-3,5,-3,-2,8,-7};
        int k = 3;
        System.out.println(maxSum(arr,k));
        System.out.println(maxSumSubArr(arr,k));
//        System.out.println(Arrays.toString(arrFirstNegNo(arr1,k)));
//        System.out.println(countAnagram("for","forxxorfxdofr"));
    }
    static int maxSum(int[] arr, int k){
        int sum = 0,l=0, r= k-1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        while(r<arr.length-1){
            sum -=arr[l];
            l++;
            r++;
            sum +=arr[r];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
    static int maxSumSubArr(int[] arr, int k){
        int i = 0,j =0,sum = 0;
        int max = Integer.MIN_VALUE;
        while(j < arr.length){
            sum += arr[j];
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
            }
            j++;
        }
        return max;
    }
    static void maxSubArr(int[] arr,int n, int k){
        int j,max;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }
    static int[] arrFirstNegNo(int[] arr, int k){
        int i=0,j=0;
        int[] ans=new int[10];
        while(j < arr.length){
            if(j-i+1 == k){
                for (int l=i ; l < k+i; l++) {
                    if(arr[l] < 0){
                        ans[i] = arr[l];
                        break;
                    }
                }arr[i]=0; i++;
            }j++;
        }
        return ans;
    }
    static int countAnagram(String pat, String txt) { //
        int patlen = pat.length();//3
        int txtlen = txt.length();//13

        int patArray[] = new int[26];
        int txtArray[] = new int[26];
        for(int i=0;i<patlen;i++) {
            patArray[pat.charAt(i)-'a']++;
            txtArray[txt.charAt(i)-'a']++;
        }
        int count = 0;
        if(Arrays.equals(patArray,txtArray)) count++;
        for(int i=patlen;i<txtlen;i++) {
            txtArray[txt.charAt(i)-'a']++;
            txtArray[txt.charAt(i-patlen)-'a']--;
            if(Arrays.equals(patArray,txtArray)) count++;
        }
        return count;
    }
}
