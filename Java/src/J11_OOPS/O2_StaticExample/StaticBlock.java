package J11_OOPS.O2_StaticExample;

//this is a demo to show initialization of static variables
public class StaticBlock {
    static int a =4;
    static int b;
    //will only run once,when the first obj is create
    static {
        System.out.println("I am in static block");
        b = a * 5;
    }
    public static void main(String[] args){
        StaticBlock ojb = new StaticBlock();
        System.out.println(StaticBlock.a + " " +StaticBlock.b);
        StaticBlock.b += 3;

        System.out.println(StaticBlock.a + " " +StaticBlock.b);

        StaticBlock ojb2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " +StaticBlock.b);
    }
}
