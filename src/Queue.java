import java.sql.PseudoColumnUsage;
import java.util.LinkedList;

public class Queue {

    public ListNode front;
    public ListNode rear;
    public int length;

    private static class ListNode{
        private final int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void insert(int data){
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            front = temp;
        }else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int remove(){
        int temp = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        length--;
        return temp;
    }

    public void queuePrint(){
        if (isEmpty()){
            return;
        }
        ListNode current = front;
        while (current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static String[] generateBinary(int n){
        String[] result = new String[n];
        java.util.Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i = 0; i < n; i++){
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.queuePrint();
        queue.remove();
        queue.queuePrint();
        String[] arr = generateBinary(5);
        for (String j : arr){
            System.out.println(j);
        }
    }
}
