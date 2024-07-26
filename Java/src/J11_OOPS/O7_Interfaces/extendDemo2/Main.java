package J11_OOPS.O7_Interfaces.extendDemo2;

public class Main implements A, B{
    @Override
    public void greet() {

    }

    public static void main(String[] args) {
        Main obj = new Main();
        A.greeting();
    }
}
