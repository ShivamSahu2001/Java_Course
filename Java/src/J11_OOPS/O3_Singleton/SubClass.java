package J11_OOPS.O3_Singleton;

import J11_OOPS.O5_Access.A;

public class SubClass extends A {
    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(45, "Shivam Sahu");
        int m = obj.num;
        A obj1 = new A(54, "Shivam sahu");
//        int n = obj1.num;   //parent don't know how extending me

    }
}
    class SubSubClass extends SubClass{

        public SubSubClass(int num, String name) {
            super(num, name);
        }
        public static void main(String[] args) {
            SubSubClass obj2 = new SubSubClass(23,"kunal");
            int o = obj2.num;
        }
    }
class SubClass2 extends A{
    public SubClass2(int num, String name) {
            super(num, name);
        }

    public static void main(String[] args) {
        A obj = new A(23,"Saurabh");
//        int n = obj.num;
    }
}
