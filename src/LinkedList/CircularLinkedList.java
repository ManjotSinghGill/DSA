package LinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {

    //Initializing circular linked list
    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
            length++;
        }
    }

    public CircularLinkedList(){
        last = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    //display and traverse circular linked list
    public void displayCll(){
        if (isEmpty()){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data + "-->");
            first = first.next;
        }
        System.out.println(first.data);
    }

    //Insertion
    public void insertAtFirst(int data){
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            last = temp;
        }else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void insertAtEnd(int data){
        ListNode temp = new ListNode(data);
        if (isEmpty()){
            last = temp;
            last.next = last;
        }else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    //Delete first node
    public ListNode deleteAtFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (last.next == last){
            last = null;
        }else {
            last.next = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    //main
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.createCircularLinkedList();
        cll.displayCll();
        cll.insertAtFirst(56);
        cll.displayCll();
        cll.insertAtEnd(99);
        cll.displayCll();
        cll.deleteAtFirst();
        cll.deleteAtFirst();
        cll.deleteAtFirst();
        cll.displayCll();
    }
}
