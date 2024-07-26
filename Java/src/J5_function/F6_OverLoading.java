package J5_function;


import java.util.Arrays;

public class F6_OverLoading {
    public static void main(String[] args) {
         fun(67);
         fun("Shivam Sahu");
        demo( 2,5,7,5,4,4,7,4,5);
        demo("shivam","saurabh","divyanshu","ashirvad","vikas");
//         demo(); Ambiguity Error
    }
    static void fun (int a){
        System.out.println(a);
    }
    static void fun (String name){
        System.out.println(name);
    }
    static void demo(int ...b){
        System.out.println(Arrays.toString(b));
    }
    static void demo(String ...c){
        System.out.println(Arrays.toString(c));
    }
}
