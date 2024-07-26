package J13_Recursion.Array;//1342 count steps

public class R4_countZeros {
    public static void main(String[] args) {
        System.out.println(count(30456703));
    }
    static int count(int n){
        return helper(n,0);
    }
    private static int helper(int n,int c){
        if(n==0){
            return c;
        }
        if(n%10 == 0){
            return helper(n/10,c+1);
        }
        return helper(n/10,c);
    }
}
