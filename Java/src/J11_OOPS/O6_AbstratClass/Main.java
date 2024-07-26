package J11_OOPS.O6_AbstratClass;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();

        Daughter daughter = new Daughter(28);
//        Parent daughter = new Daughter(28); // you can't create obj,
//        but we can use as a refernce variable
        daughter.career();

//        Parent mom = new Parent(45); // You can't crate obj of Abstract class
        // (but we can createusing override)
        Parent.hello();
        son.normal();
        Parent obj = new Parent(5)
        {
            @Override
            void career() {
                System.out.println("I am in main ");
            }
            @Override
            void partner() {
                System.out.println("I am in main partner");
            }
        };
        obj.career();
        obj.normal();
    }
}
