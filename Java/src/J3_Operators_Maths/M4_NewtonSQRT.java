package J3_Operators_Maths;

public class M4_NewtonSQRT { //T.C- ((logN)f(N)   Assuption
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }
    static double sqrt(double n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n/x));

            if (Math.abs(root - x) < 0.5) {
                break;
            }

            x = root;
        }
        return root;
    }
}