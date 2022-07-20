package LinkedList;

public class SingleLinkedList {

    public static LinkedNode head;

    public static class LinkedNode {
        private int data;
        private LinkedNode next;

        public LinkedNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void displayLinkedList(LinkedNode head){
        LinkedNode current = head;
        while (current != null){
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.print("null");
    }

    public int length(){
        LinkedNode current = head;
        int count = 0;
        while (current != null){
            count += 1;
            current = current.next;
        }
        return count;
    }

    // Insertion Operations
    public void insertAtFirst(int data){
        LinkedNode newNode = new LinkedNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        LinkedNode newNode = new LinkedNode(data);
        if (head == null){
            head = newNode;
            return;
        }
        LinkedNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPosition(int Position, int data){
        LinkedNode newNode = new LinkedNode(data);
        if(Position == 1){
            insertAtFirst(data);
        }
        else{
            int count = 1;
            LinkedNode previous = head;
            while(count < Position -1){
                previous = previous.next;
                count++;
            }

            LinkedNode current = previous.next;
            previous.next = newNode;
            newNode.next = current;
        }

    }

    // Deletion Operations
    public void deleteAtFirst(){
        LinkedNode current = head;
        head = current.next;
    }

    public LinkedNode deleteAtEnd(){
        if(head == null || head.next == null){
            return head;
        }
        LinkedNode current = head;
        LinkedNode previous = null;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void deleteAtPosition(int position){
        if (position == 1){
            head = head.next;
        }
        else{
            LinkedNode previous = head;
            int count = 1;
            while(count < position - 1){
                count++;
                previous = previous.next;
            }
            LinkedNode current = previous.next;
            previous.next = current.next;
        }
    }

    //Find an element in Linked List
    public boolean ifExist(int data){
        LinkedNode current = head;
        while (current != null){
            if (current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Reverse Linked List
    public LinkedNode reserseLinkedList(LinkedNode head){
        if (head == null){
            return head;
        }
        LinkedNode current = head;
        LinkedNode previous = null;
        LinkedNode next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //Find the middle node (Both even and odd LinkedList)
    public LinkedNode findMiddle(LinkedNode head){
        LinkedNode slowPtr = head;
        LinkedNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    //Find the nth node from the end of Linked List
    public LinkedNode findFromLast(LinkedNode head, int n){
        LinkedNode mainPtr = head;
        LinkedNode refPtr = head;
        int count = 0;
        while(count < n){
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null){
            refPtr =refPtr.next;
            mainPtr =  mainPtr.next;
        }
        return mainPtr;
    }

    //Remove duplicate from sorted Linked List
    public LinkedNode removeDupSorted(LinkedNode head){
        LinkedNode current = head;
        while(current != null && current.next != null){
            if (current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    //Insertion in sorted Linked List
    public LinkedNode insertSorted(LinkedNode head, int data){
        LinkedNode newNode = new LinkedNode(data);
        LinkedNode current = head;
        LinkedNode previous = null;
        while(current != null && current.data < newNode.data){
            previous = current;
            current = current.next;
        }
        newNode.next = current;
        previous.next = newNode;
        return head;
    }

    //Remove from Linked List with given key
    public void removewithkey (LinkedNode head, int key){
        LinkedNode current = head;
        LinkedNode previous = null;
        while(current != null && current.data != key){
            previous = current;
            current = current.next;
        }
        if (current == null){return;}
        previous.next = current.next;
    }

    public static void main(String[] args){

        SingleLinkedList SLL = new SingleLinkedList();
        SLL.head = new LinkedNode(1);
        LinkedNode second = new LinkedNode(2);
        LinkedNode third = new LinkedNode(3);
        LinkedNode temp = new LinkedNode(3);
        LinkedNode fourth = new LinkedNode(4);
        LinkedNode fifth = new LinkedNode(5);

        //Linking nodes together

        head.next = second;
        second.next = third;
        third.next = temp;
        temp.next = fourth;
        fourth.next = fifth;


        SLL.displayLinkedList(head);
        SLL.removewithkey(head, 3);
        SLL.displayLinkedList(head);
    }
}
