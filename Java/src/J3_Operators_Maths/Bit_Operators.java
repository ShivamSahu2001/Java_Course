package J3_Operators_Maths;
//And,or,Xor,complement,LeftShift(first convert into binary,add 0 last == double the no),
// RightShift(first convert into binary,ignore left one == divide by 2)
import java.util.Arrays;

public class Bit_Operators {
    public static void main(String[] args) {
//        int num = 1243;
//        System.out.println(isOdd(num));
//        int[] arr ={2,3,3,4,2,6,4};
//        System.out.println(unique(arr)); //136
//        int[] arr1={1,2,1,2,2,1,3};
//        System.out.println(singleNumberII(arr1)); //137
//        int[] arr2 ={ };
//        System.out.println(singleNumberIII(arr2)); //260
//        System.out.println(findIthBit(6,3));
//        System.out.println(setIthBit1(4,2));
//        System.out.println(resetIthBit0(6,2));
//        System.out.println(rightMSetBit(4));
//        System.out.println(noOfBaseDigit(8,2));
//        System.out.println(Integer.toBinaryString(10));
//        System.out.println(noSetBits(45));
//        System.out.println(count1from32bit(24));
        System.out.println(Arrays.toString(coutBitRange(5)));
    }
    static boolean isOdd(int num) {  //TC-O(n),SC-O(1)
        return (num & 1) == 1;    // it depend upon (LSB-least significant bit ->last bit)
    }

    static int unique(int[] arr) {
        int ans =0;
        for(int n:arr){
            ans ^= n;   //mask
        }
        return ans;
    }
    static int singleNumberII(int[] arr1){ //(8)three pairs every
        int ans = 0;
        for(int i =0 ;i<32;i++){
            int sum = 0;
            for(int j =0;j<arr1.length;j++){
                if(((arr1[j] >> i) & 1) ==1)
                    sum++;
            }
            sum %=3;
            if(sum !=0){
                ans |= sum << i;
            }
        }
        return ans;
    }
    static int[] singleNumberIII(int[] arr2) {
        int mask =0;
        for(int n:arr2){
            mask ^=n;
        }
        mask &= -mask;
        int[] result = new int[2];
        for(int n:arr2){
            if((mask & n) == 0) result[0] ^=n;
            else result[1] ^=n;
        }
        return result;
    }

    static int findIthBit(int n,int bit){
        return ((n & (1 << (bit - 1))) >> (bit - 1));   //mask
    }
    static int setIthBit1(int n,int bit){
        return n | (1 << (bit - 1));                    //mask
    }
    static int resetIthBit0(int n, int bit){
        return n & ~(1 << (bit -1));                    //mask
    }
    static int rightMSetBit(int n){
        return (n & (-n));
    }
    static int noOfBaseDigit(int num,int base){  //TC- log(n)
        return (int)(Math.log(num)/Math.log(base)) + 1;       //mask
    }
    static int noSetBits(int n){  //count 1
        int count = 0;
//        while(n > 0){
//            count++;
//            n -=(n & -n);
//        }
        while(n > 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
    static int count1from32bit(int n){ //191
        //right most set bit value
        //n & (1 << i)      O(32)
        //n &= -n           O(1)
        int count =0;
//        for(int i =0;i<32;i++){
//            if(((n & (1 << i)) >>i) !=0){
//                count ++;
//            }
//        }
//        return count;
        while(n !=0){  //n>0 will wrong for (1111...32terms it is negative value)
            n = n & (n-1);  //right most set bit become zero every time
            count++;
        }
        return count;
    }
    static int[] coutBitRange(int n){  //Leetcode -338
//        int[] arr= new int[n+1];
//        arr[0]=0;
//        for (int i = 1; i <arr.length; i++) {
//            arr[i]=arr[i/2] + i%2;    //it uses data of i/2
//        }
//        return arr;
        int[] arr = new int[n+1];
        arr[0]=0;
        for (int i = 1; i <arr.length; i++) {
            arr[i]=countForI(i);
        }
        return arr;
    }
    static int countForI(int i){
        int count =0;
        while(i>0){
            i = i & (i-1);
            count++;
        }
        return count;
    }
}
