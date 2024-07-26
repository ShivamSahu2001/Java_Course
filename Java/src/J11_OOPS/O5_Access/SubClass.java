package J11_OOPS.O5_Access;

public class SubClass extends A{
    public SubClass(int num, String name) {
        super(num, name);
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass(45,"Shivam Sahu");
        int m = obj.num;
        A obj1 = new A(54,"Shivam sahu");
        int n = obj1.num;
        System.out.println(obj instanceof A);
        System.out.println(obj instanceof SubClass);
        System.out.println(obj1.getClass());
        System.out.println(obj1.getClass().getName());

    }
}
