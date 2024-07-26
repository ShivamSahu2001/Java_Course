package J2_Conditions_Loop;

public class C1_If_Else {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        int c = 33;
        int max = Math.max(a,b);
        int max1 = Math.max(c,Math.max(a,b));
        System.out.println(max);
        System.out.println(max1);
        //if-elseIf-else(multiple if else)
        int salary =25400;
        if(salary > 10000){
            salary +=2000;
        }  else{
            salary +=1000;
            System.out.println("b");
        }
        System.out.println(salary);//not going inside
    }
}
