package J11_OOPS.O2_StaticExample;
//static variable resolved at complile time
public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population=0;  //static variable didn't depand upon obj
    static String message(){
        System.out.println("Hello My name is Shivam Sahu");
        return "Welcome Sir";
    }
    Human(int age, String name, int salary, boolean married){
        this.age =age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population++;  //for static we use class.population
        Human.message();
    }

}
