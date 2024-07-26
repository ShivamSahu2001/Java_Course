package J11_OOPS.O4_Properties.Polymorphism;
//(1) Compile Time/Static polymorphism (Achieved by method/constructor Overloding ie. argument,reutrn types)
//(2) Run Time/Dynamic polymorphism(Achieved by method overriding)

public class Main {
    public static void main(String[] args) {
//        Shapes shape = new Shapes();
//        Circle circle = new Circle();
        Shapes square = new Square(); //upcasting
        //objet type define which method to run(upcasting),
        //and reference type define which one access
        //which area will call it dertemine at run time using dynamic method dispatch

//        shape.area();
//        circle.area();
        square.area();
    }
}
