package J15_Stack_Queues_DeQue.S3_CustomQueue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        //CustomQueue queue = new CustomQueue(5);
        CircularQueue queue = new CircularQueue(5);
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();  //O(n)
        System.out.println(queue.remove());//O(1) for circular, O(n) for normal
        queue.insert(133);
        queue.display();  //O(n)

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();  //O(n)

    }
}
