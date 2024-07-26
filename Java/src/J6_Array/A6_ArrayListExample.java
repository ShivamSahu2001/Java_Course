package J6_Array;
import java.util.ArrayList;
import java.util.Scanner;

public class A6_ArrayListExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(67);
        list.add(684);
        list.add(384);
        list.remove(1);
        System.out.println(list);
        list.set(0,23);
        list.clear();
        list.add(68);
        list.add(647);
        System.out.println(list);
        for (int i = 0; i <5 ; i++) {
            list.add(s.nextInt());
        }
        System.out.println(list);
        //get item at any index
        for (int i = 0; i <7 ; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
