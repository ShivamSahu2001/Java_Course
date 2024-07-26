package J11_OOPS.O4_Properties.Inheritance;
//(1) single inheritance(one class extends another class),
//(2) multilevel inheritance(child become parent for any other class),
//(3) multiple inheritance(one class extending more than one class) it cover in interfaces
   // It not support in java because problem arising, if parent class having same variable/properties
//(4) Hierarchical inheritance(one class inherited by many class)
//(5) Hybrid inheritance(combination of single and multiple inheritance) not allowed, cover in interfaces
// Note:- final,static methods cannot be inherited & override
public class Box { //if we use final class than it can't inheritance,it also implicitly all its method final aswell
    private double l=-1; //data hiding
    double h;
    double w;
    double weight=3;

    public double getL(){  //Encapsulation(wraping the data to hide the complexity of system
        return l;  //subprocess of datahiding, process of containing information
    }
    //this is static method this is not depand upon obj
    static void greeting(){
        System.out.println("Hey, I am in Box class. Greeting!");
    }

    Box(){
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }
    Box(double side){
        //super(); Every class inherit Object class (OC -> PC -> CC)

        this.l = side;
        this.h = side;
        this.w = side;
    }
    Box(double l, double h, double w){
        this.l = l;
        this.h = h;
        this.w = w;
    }
    Box(Box old){
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

}
