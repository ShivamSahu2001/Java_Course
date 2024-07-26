package J5_function;

public class F4_Shadowing {
    static int x =90;  // This will be shadowed at line 8
    public static void main(String[] args) {
        System.out.println(x); //90
        int x ; // By creating new x we directly shadowed class x.
//      System.out.println(x);  "Error->Variable 'x' not have been initialized"
        x =  40;
        System.out.println(x);  //40
        fun();  //90
    }
    static void fun(){
        System.out.println(x);
    }

}
