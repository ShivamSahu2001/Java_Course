package J1_Basic_Java;
import java.util.Scanner;
public class StaticBlockInitializer {
    static int B,H;
    static boolean flag=true;
    static{
        Scanner s=new Scanner(System.in);
        B=s.nextInt();
        H=s.nextInt();
        if(B<=0 || H<=0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag=false;  //main function flag not execute
        }
    }
    public static void main(String[] args) {
        if(flag){
            int area=B*H;
            System.out.println(area);
        }
    }
}
