package J15_Stack_Queues_DeQue.S4_InterviewQuestion;
import java.util.Stack;
//https://leetcode.com/problems/implement-queue-using-stacks/description/
public class Q1_ImpleQueueUsingStack {
    public static void main(String[] args) throws Exception {
        QueueUsingStackRemove obj = new QueueUsingStackRemove();
        obj.add(2);
        obj.add(5);
        obj.add(7);
        obj.add(3);
        obj.add(4);
        System.out.println(obj.remove());
        System.out.println(obj.peek());
        System.out.println(obj.remove());
    }
    public static class QueueUsingStack{
        private Stack<Integer> first;
        private Stack<Integer> second;
        public QueueUsingStack(){
            first = new Stack<>();
            second = new Stack<>();
        }
        public void add(int item){
            first.push(item);
        }
        public int remove() throws Exception{
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            int removed = second.pop();
            while(!second.isEmpty()){
                first.push(second.pop());
            }
            return removed;
        }
        public boolean isEmpty(){
            return first.isEmpty();
        }
        public int peek(){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            int peeked = second.peek();
            while(!second.isEmpty()){
                first.push(second.pop());
            }
            return peeked;
        }
    }
    public static class QueueUsingStackRemove{
        private Stack<Integer> first;
        private Stack<Integer> second;
        public QueueUsingStackRemove(){
            first = new Stack<>();
            second = new Stack<>();
        }
        public void add(int item){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            first.push(item);
            while(!second.isEmpty()){
                first.push(second.pop());
            }
        }
        public int remove() throws Exception{
            return first.pop();
        }
        public boolean isEmpty(){
            return first.isEmpty();
        }
        public int peek(){
            return first.peek();
        }
    }
}

