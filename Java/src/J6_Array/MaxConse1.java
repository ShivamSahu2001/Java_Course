package J6_Array;

public class MaxConse1 {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,0,1,1};
        System.out.println(max1Count(arr,9));
    }
    static int max1Count(int[] arr,int n){
        int count=0;
        int max =0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==1){
                count +=1;
                max =Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }
}
