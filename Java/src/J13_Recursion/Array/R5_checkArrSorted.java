package J13_Recursion.Array;
public class R5_checkArrSorted {
    public static void main(String[] args) {
        int[] arr ={1,22,3,4,56};
        System.out.println(SortedCheck(arr,0));
    }
    static boolean SortedCheck(int[] arr,int index){
        if(index == arr.length-1){
            return true;
        }
        return (arr[index]<arr[index+1]) && SortedCheck(arr,index+1);
    }
}
