package J5_function;

import java.util.Arrays;

public class F5_VarLengthArg {
    public static void main(String[] args) {
        fun(55,56,74,85,78,45,88);
        //  fun();  Empty Array gives
        multiple(55,66, "Shivam","Saurabh");
    }
    static void fun(int ...v){

        System.out.println(Arrays.toString(v));
    }
    static void multiple(int a, int b, String ...v){
        System.out.println(a+" "+b+" "+Arrays.toString(v));
    }
}
