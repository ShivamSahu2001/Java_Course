package J11_OOPS.O1_Introduction;

public class Introduction {
    public static void main(String[] args) {
        // object is an instances of class
        Student student1 = new Student("Shivam",34,78.3f);
        Student student2 = new Student(student1); //new Dynamic memory allocation & return ref to it
        System.out.println(student1.name);
        System.out.println(student1.rollno);
        System.out.println(student1.marks);
//        student1.changeName("Saurabh");
//        student1.greeting();

//        Student random = new Student();
//        Student random2 = random;
//        System.out.println(random2.name);

        final int a;  //we can't modify a
//        a =234;
//        final Student A = new Student();
//        A.name ="satyam";            //in non primitive case(obj) we can modify it
//        A = new Student("new object");  //but not intialized again as obj

//        Student obj;       //checking garbage collector
//        for (int i = 0; i < 346314613; i++) {
//            obj = new Student("Random Name");
//        }

    }

}
class Student{//logical construct Name group of functions and properties,
    // it is templete of object
//     final int a;   //you have to initialize
    String name="Shivamsahu";
    int rollno;
    float marks;
    void changeName(String newName){
        name = newName;
    }
    void greeting(){
        System.out.println("Hello my name is : "+name);
    }
    Student(String name){
        this.name = name;
    }
    Student (Student other){
        this.name = other.name;   //student2.name = student1.name
        this.rollno = other.rollno;
        this.marks = other.marks;
    }

    Student(String name, int rollno, float marks){
        this.name = name;
        this.rollno = rollno;
        this.marks = marks;
    }
    Student (){  //Calling Constructor from another constructor
        this ("default person",13,100.0f);  //Student();
    }
//    Student(String nam, int roll, float mark){
//        name =nam; //it is valid because name = nam(class variable should not same)
//        rollno = roll;
//        marks = mark;
//    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
//this keyword is a reference to the current instance of the class
//This is useful when there is a local variable or parameter with the same name as
// an instance variable, to differentiate between the two.