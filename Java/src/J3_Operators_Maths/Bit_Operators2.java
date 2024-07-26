package J3_Operators_Maths;
import java.util.Arrays;
public class Bit_Operators2 {
    public static void main(String[] args) {
        System.out.println(reverse32Bits(100));
//        System.out.println(xor(9));
//        System.out.println(rangeXor(3,9));
//        int[][] arr ={{1,1,0},{1,0,1},{0,0,0}};
//        flipAndInvertImage(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println(magicNumber(6));
//        System.out.println(pascalRowSum(3));
//        System.out.println(powerof2(34));
//        PowerOfBase(3,6);
    }
    static int reverse32Bits(int n) { //Leetcode 190
        int ans =0;
        for(int i=0;i<32;i++){
            ans <<= 1;
            // if((n & 1)==1)
            //    ans++;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
//        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
//        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
//        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
//        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
//        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
//        return n;
    }
    // this gives xor from 0 to a
    static int xor(int a) {
        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1) {
            return 1;
        }
        if (a % 4 == 2) {
            return a + 1;
        }
        return 0;
    }
    static int rangeXor(int a, int b){
        int ans = xor(b) ^ xor(a-1);
        return ans;

        // only for check, will give TLE for large numbers
//        int ans2 = 0;
//        for (int i = a; i <= b; i++) {
//            ans2 ^= i;
//        }
//        System.out.println(ans2);
    }
    static int[][] flipAndInvertImage(int[][] image) {  //832
        for(int[] row : image) {
            // reverse this array
            for (int i = 0; i < (image[0].length + 1) / 2; i++) {
                // swap
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length - i - 1] ^ 1;
                row[image[0].length - i - 1] = temp;
            }
        }
        return image;
    }
    static int magicNumber(int n){ //binary no right digit multiplication by base and add.
        int ans = 0;
        int base = 5;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            ans += last *base;
            base = base *5;
        }
        return ans;
    }
    static int pascalRowSum(int rowno){  //sum of nth row = 2^(n-1) =1 * 2^(n-1)
        return 1<<(rowno-1);
    }
    static boolean powerof2(int n){
        return (n & (n-1)) == 0;
    }
    static void PowerOfBase(int base,int power){  //(13)log(power time)
        int ans =1;                     //3^6 = 3^110 = 3^4 * 3^2 * 3^0
        while(power > 0){
            if((power & 1)==1){
                ans *=base;
            }
            base *= base;
            power = power >> 1;
        }
        System.out.println(ans);
    }

}
