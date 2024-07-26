package J11_OOPS.O4_Properties.Polymorphism;
// Poly(many) Morphism(ways to represent)
// java support this that why we call java is Object oriented programming lanaguage
// Hierarchical inheritance-> one parent many children
public class Shapes {
    //which area should call,it determine by dynamic method dispach (dynamic polymorphism)
    void area(){ //if we add final than it will not overriding
        System.out.println("I am in a shapes");
    }
      //Early binding at complile time
//    final void area(){ //if we add final than it will not overriding
//        System.out.println("I am in a shapes");
//    }
     // late binding is run time binding
}
