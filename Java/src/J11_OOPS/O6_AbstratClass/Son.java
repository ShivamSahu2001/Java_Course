package J11_OOPS.O6_AbstratClass;

public class Son extends Parent{
//    public Son(int age){
//        this.age = age;
//    }
    public Son(int age){
        super(age);
    }
    @Override
    void normal(){
        super.normal();
    }

    @Override
    void career() {
        System.out.println("I am going to be a doctor");
    }

    @Override
    void partner() {
        System.out.println("I love Pepper Potts" );

    }
}
