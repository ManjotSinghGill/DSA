package LinkedList;

import java.util.List;
import java.util.NoSuchElementException;

public class DoubleLinkedList {

    private ListNode head;
    private ListNode tail;
    private int lenght;

    public static class ListNode{
        int data;
        ListNode previous;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.lenght = 0;
    }

    public boolean isEmpty(){
        return lenght==0 || head == null;
    }

    public int getLenght(){
        return lenght;
    }

    public void displayForward(){
        ListNode temp = head;
        if (head == null){
            return;
        }
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if (tail == null){
            return;
        }

        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.print("null");
    }

    //Insert in the Double Linked List
    public void insetAtFront(int data){
        ListNode newNode = new ListNode(data);
        if (isEmpty()){
            tail = newNode;
        }else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        lenght++;
    }

    public void insertAtEnd(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    //Deletion of node in Double Linked List
    public ListNode deleteAtFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if (head == tail){
            tail = null;
        }else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteAtEnd(){
        if (isEmpty()){
            throw  new NoSuchElementException();
        }
        ListNode temp = tail;
        if (head == tail){
            head = null;
        }else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp;
    }

    //main
    public static void main(String[] args){

        DoubleLinkedList dll = new DoubleLinkedList();

        dll.insetAtFront(1);
        dll.insetAtFront(2);
        dll.insetAtFront(3);
        dll.insetAtFront(4);

        dll.displayForward();

        dll.deleteAtEnd();
        dll.displayForward();
    }
}
