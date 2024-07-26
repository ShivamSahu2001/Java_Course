package J6_Array;

public class A5_Amazon {
    public static void main(String[] args) {
        int[][] arr={{4,20,3,5}, {1, 2, 40, 5}, {2, 60 ,4, 1}};
        System.out.println(indexReturn(arr));
    }
    static int indexReturn(int[][] arr){
        int max=0,count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>max){
                    max=arr[i][j];
                    count++;
                }
            }
            if(count>3){
                return i;
            }
        }return -1;
    }
}
