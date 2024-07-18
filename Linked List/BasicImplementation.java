class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node n) {
        this.value = value;
        this.next = n;
    }
}
class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    public void insertAtFirst(int value) {
        size++;
        Node n = new Node(value);
        if (head == null) {
            head = n;
            tail = n;
            // or
            insertAtLast(value);
        } else {
            n.next = head;
            head = n;
        }
    }

    public void insertAt(int index, int value){
        size++;
        if (index == this.size - 1) {
            insertAtLast(value);
            return;
        }
        if (index == 0) {
            insertAtFirst(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        Node n = new Node(value);

        if (head == null) {
            insertAtFirst(value);
        } else {
            n.next = temp.next;
            temp.next = n;
        }
    }

    public void insertAtLast(int value) {
        size++;
        Node n = new Node(value);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void display() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public Node get(int index) {
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }
    //getNthNodeFromLast
    public Node getLast(int index) {
        Node n = head;
        for (int i = 0; i < size-index; i++) {
            n = n.next;
        }
        return n;
    }

    public void deleteFirst() {
        if (size == 0) {
            System.out.println("Already Empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    public void deleteLast() {
        if (size == 0) {
            System.out.println("Already Empty");
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }
     public int getSize(){
        int size=0;
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
             size++;
        }
         return size+1;
     }
    

    public void deletefrom(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void rev(){
        Node prev=null;
        Node current =head;
        Node after=null;
        while (current!=null) {
            after =current.next;
            current.next =prev;
            prev=current;
            current = after;            
        }
        head=prev;
    }
}
public class BasicImplementation {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertAtLast(0);
        l1.insertAtLast(1);
        l1.insertAtLast(2);
        l1.insertAtLast(3);
        l1.insertAtLast(4);
        l1.insertAtLast(5);
               
        l1.rev();
          //System.out.println(l1.head.value);
          //int value=7;
        l1.display();

    // System.out.println("hello world");
        // // l1.insertAtFirst(90);
        // System.out.println("size " + l1.size);
        // l1.insertAt(3, -897);
        // l1.display();
        // System.out.println();
        // System.out.println(l1.get(0).value);
        // l1.deleteFirst();
        // l1.display();
        // System.out.println();
        // System.out.println(l1.head.value);

        // l1.deleteLast();
        // l1.display();
        // System.out.println();
        // System.out.println(l1.tail.value);

        // l1.deletefrom(3);
        // l1.display();
    }
}