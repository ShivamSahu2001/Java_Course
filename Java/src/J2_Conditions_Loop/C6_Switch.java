package J2_Conditions_Loop;

import java.util.Scanner;

public class C6_Switch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String fruit = s.next();
        String day = s.next();
        switch (fruit) {
            case "Mango":
                System.out.println("King of fruits");
                break;
            case "Apple":
                System.out.println("A sweet red fruit");
                break;
            case "Orange":
                System.out.println("Round fruit");
                break;
            case "Grapes":
                System.out.println("small fruit");
                break;
            default:
                System.out.println("please enter a valid fruit name ");
        }
//        switch (fruit){
//            case "Mango" -> System.out.println("King of fruits");
//            case "Apple" -> System.out.println("A sweet red fruit");
//            case "Orange" -> System.out.println("Round fruit");
//            case "Grapes" -> System.out.println("small fruit");
//            default -> System.out.println("please enter a valid fruit name ");
//        }
//        switch (day){
//            case 1,2,3,4,5 -> System.out.println("Weekday");
//            case 6,7 -> System.out.println("Weekend");
//        }
    }
}
