package J11_OOPS.O2_StaticExample;
// static -- they are class level method, resolve during compile time
class Test{    //this class is not depandent to any other class
    String name;   //for static both Rahul
    public Test(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
                    // OR //
public class InnerClasses {   //outer class never static
    static class Test{   //it is not demand upon InnerClasses obj by using static
        String name;   //for static both Rahul
        public Test(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Shivam");
        Test b = new Test ("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
        System.out.println(a);
    }
}
