package J15_Stack_Queues_DeQue.S2_CustomStack;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack(5);
       //DynamicStack stack = new DynamicStack(5);
       //CustomStack stack = new DynamicStack(5);
       //You can push as many as you want

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(18);
        stack.push(89); // Stack full for CustomStack

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
    }
}

