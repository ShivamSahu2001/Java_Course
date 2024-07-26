//Static type language java, you can't acess address reference to it in java
package J1_Basic_Java;
import java.util.Arrays;
    // Tpye casting--String.valueOf() and Integer.toString()
//  byte -128 to 127, char 0k to 65535, short -32768 to 32767, int -2147483648 to 2147483647
//  long -9223372036854775808 to 9223372036854775807, float 1.40239846e-45f to 3.40282347e+38f
//  double 4.94065645841246544e-324 to 1.79769313486231570e+308
public class DataType {
    public static void main(String[] args) {
      int i=10;
      System.out.println(((Object)i).getClass().getSimpleName());
      char ch='s';
      System.out.println(((Object)ch).getClass().getSimpleName());
      String name="Shivam";
      System.out.println(name.hashCode()); //address check
      System.out.println(name.getClass().getSimpleName());
      increment(i);
      System.out.println(i);

      int[] arr={1,43,4,35};
      Arrayincrement(arr);
      System.out.println(Arrays.toString(arr));

      int arr1[] = new int[5];
      change(arr1);
      System.out.println(arr1[0]);

    }
    static void increment(int i){
        i++;
    }
    static void Arrayincrement(int input[]){
        for (int i = 0; i < input.length; i++) {
            input[i]++;
        }
    }
    static void change(int[] input){
       // input = new int[5];  //if we create new object then it independant to pass[]
        input[0] = 15;
    }
}
