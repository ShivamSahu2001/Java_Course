package J15_Stack_Queues_DeQue;

import J15_Stack_Queues_DeQue.S2_CustomStack.StackException;

public class abc {
    protected int[] data ;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;
    int front = 0;
    int size = 0;
    public abc(){
        this(DEFAULT_SIZE);
    }

    public abc(int size) {
        this.data = new int[size];
    }
    public boolean insert(int item) throws StackException {
        if(isFull()){
            return false;
        }
        data[end++]=item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws StackException{
        if(isEmpty()){
            throw new StackException("We can't remove in Empty Stack");
        }
        int remove = data[front++];
        front = front % data.length;
        size++;
        return remove;
    }
    public int front() throws StackException{
        if(isEmpty()) {
            throw new StackException("Can't find front because stack is Empty");
        }
        return data[front];
    }
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
    public boolean isFull(){
        return end == data.length;
    }
    public boolean isEmpty(){
        return end == 0;
    }

    public static void main(String[] args) throws StackException{
        abc obj = new abc();
        obj.insert(32);
        obj.insert(234);
        obj.insert(2323);
        obj.remove();
        obj.display();
    }
}

