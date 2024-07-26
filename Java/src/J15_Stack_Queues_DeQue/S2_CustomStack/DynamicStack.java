package J15_Stack_Queues_DeQue.S2_CustomStack;

public class DynamicStack extends CustomStack{

    public DynamicStack() {
        super(); // it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size); // it will call CustomStack(int size)
    }

    @Override
    public boolean push(int item) {
        // this takes care of it being full
        if (this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        // temp also removed data remain same with double size

        // at this point we know that array is not full
        // insert item
        return super.push(item);
    }
}
