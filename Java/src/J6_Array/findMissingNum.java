package J6_Array;

public class findMissingNum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(brute(arr,4));
        System.out.println(better(arr,4));
        System.out.println(opt1(arr,4));
        System.out.println(opt2(arr,5));
    }
    static int brute(int[] arr,int n){//T-> O(n*n), S-> O(1)
        for (int i = 1; i <=n+1; i++) {
            int flag =0;
            for (int j = 0; j <n ; j++) {
                if(arr[j]==i){
                    flag =1;
                    break;
                }
            }
            if(flag ==0){
                return i;
            }
        }
        return -1;
    }
    public static int better(int[] arr, int N) {//T-> O(2*N), S-> O(N),
        int hash[] = new int[N + 1];
        for (int i = 0; i < N - 1; i++)
            hash[arr[i]]++;
        for (int i = 1; i <= N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    public static int opt1(int []a, int N) {//T-> O(N), S-> O(1)
        int sum = (N * (N + 1)) / 2;
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }
        return sum - s2;
    }
    public static int opt2(int []a, int N) {//T-> O(N), S-> O(1)
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]
        return (xor1 ^ xor2); // the missing number
    }
}
