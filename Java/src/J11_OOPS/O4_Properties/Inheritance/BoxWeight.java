package J11_OOPS.O4_Properties.Inheritance;

public class BoxWeight extends Box {
    // parent class don't know about what child class(variables) contains
    // BoxWeight is child/derived/subclass from parent/base/superClass Box
    double weight;

    public BoxWeight(){
        this.weight = -1;
    }
    //    @Override  //static method can't override because it is not depand upon obj,
        // but we can inherited
    static void greeting(){
        System.out.println("Hey, I am in BoxWeight class. Greeting!");
    }
    public BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }
    public BoxWeight(double side, double weight){
        super(side);
        this.weight = weight;
    }
    public BoxWeight(double w ,double h, double l, double weight){
        // if super class is not there it will automaticaly call default constructor
        super(w,h,l);    //first intialize super (subclass,parent)
        // calling parent class constructor
        this.weight = weight;   // then weight (base class, child class)
        System.out.println(super.weight);  //it will call just upper superclass weight

    }
}
