package J11_OOPS.O4_Properties.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4,3,4);
        System.out.println(box1.getL());  //Abstraction, process of gaining information
//        box1.l;   //it give error because l is private
//        Box box2 = new Box(box1);
//        System.out.print(box1.l + " " + box1.h +" " + box1.w);
        BoxWeight box3 = new BoxWeight();
        System.out.println(box3 instanceof Box);
        System.out.println(box3 instanceof Object);
        System.out.println(box3.getClass());
//        BoxWeight box4 = new BoxWeight(4,7,6,2);
//        System.out.println(box3.h + " " + box3.weight);
//        System.out.println(box4.h + " " + box4.weight);

//        objet type define which one to run, and reference type define which one access
//        java determine this by Dynamic method dispach

//        Box box5 = new BoxWeight(3,5,3,33);
//        System.out.println(box5.w);  //Can't call weight
//        BoxWeight box6 = new Box(4,3,2);   //we call Box constructor weight is not there
//        child(below) class known about parent, but parent(above) class doesn't know about child class

//        BoxPrice box7 = new BoxPrice(5,8,200);
//        Box box = new BoxWeight();
//        box.greeting(); //call Box

//        box3.greeting();
//        box4.greeting();
//        BoxWeight.greeting();  //inheritance static method,but override not allow
//        Box.greeting();

    }
}
