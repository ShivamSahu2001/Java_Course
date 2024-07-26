package J14_DP.D1_Basic;
//https://bit.ly/3t1Sjyx
public class B2_CountNStairs {
    public static void main(String[] args) {
        System.out.println(count(5));
    }
    static int count(int n){
        if(n==0 ||n==1){
            return 1;
        }
        return count(n-1)+count(n-2);
    }
}
