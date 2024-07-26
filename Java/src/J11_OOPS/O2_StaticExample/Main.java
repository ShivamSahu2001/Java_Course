package J11_OOPS.O2_StaticExample;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Human.population);
//        Human Ravi = new Human(23,"Ravi",30000,true);
//        Human Shivam = new Human(22,"shivam",23000,false);
//        System.out.println(Shivam.population);
//        greeting();
//        Main obj = new Main();
//        obj.greeting();
        System.out.println(Human.message());
    }
    static void fun(){
//        greeting(); //we can't call without obj
        Main obj = new Main(); //that why, referencing it
        obj.greeting();
    }
    void greeting(){
        fun();
        System.out.println("Hello world");
    }
}
