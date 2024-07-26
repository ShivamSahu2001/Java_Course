package J11_OOPS.O6_AbstratClass;

public abstract class Parent { // we can't final it becuase we have to inherite
    int age;
    final int VALUE;
    public Parent (int age){
        this.age =age;
        VALUE = 233436343;
    }
//    abstract Parent(); // we can't create constructor of abstract class
//    we can't create abstract static method, becuase method can't overriden
    static void hello(){
        System.out.println("hey");
    }
    void normal(){
        System.out.println("this is a normal method");
    }
    abstract void career();
    abstract void partner();
}
