package J5_function;

public class F2_PassingExample {
    public static void main(String[] args) {
        String name ="Shivam Sahu";
        changeName(name);
        System.out.println(name);
        int a=5,b=8;
        {
            a=50; //Reassign value
        }
        System.out.println(a);

        swap(a,b);

    }
    static void changeName(String naam){ //pass by value

        naam = "Saurabh Sahu"; // creating a new object
    }
    static void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println(num1 + " " +num2);
    }

}
