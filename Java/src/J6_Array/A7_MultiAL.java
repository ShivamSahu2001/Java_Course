package J6_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class A7_MultiAL {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list =new ArrayList<>();
        //intialisation
        for (int i = 0; i <3 ; i++) {
            list.add(new ArrayList<>());
        }
        //Add elements in Arraylist
        for (int i = 0; i < 3; i++){
            for (int j = 0; j <3 ; j++) {
                list.get(i).add(s.nextInt());
            }
        }
        System.out.println(list);
    }
}
