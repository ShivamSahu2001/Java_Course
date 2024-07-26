package J11_OOPS.O4_Properties.Polymorphism;

public class Circle extends Shapes{
    //overriding parent method
    @Override // this is called annotation
    void area(){
        System.out.println("Area is pie * r * r");
    }
}
