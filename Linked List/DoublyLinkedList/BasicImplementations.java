class Node {
    Node prev;
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class Dll {
    Node head;
    Node tail;
    int size = 0;

    // INSERTION
    public void insertAtEnd(int val) {
        size++;
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }

        tail.next = temp;
        temp.prev = tail;
        tail = temp;
        return;
    }

    public void insertAtStart(int val) {
        size++;
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }

        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public void insertAtIndex(int idx, int val) {
        if (head == null) {
            insertAtEnd(val);
            return;
        }
        if (idx == 0) {
            insertAtStart(val);
            return;
        }
        if (idx == size - 1) {
            insertAtEnd(val);
            return;
        }
        Node temp = new Node(val);
        size++;
        Node n = head;
        for (int i = 0; i < idx - 1; i++) {
            n = n.next;
        }

        temp.next = n.next;
        temp.prev = n;
        n.next.prev = temp;
        n.next = temp;
    }

    // DELETION
    public void deleteHead() {

        if (head == null) {
            System.out.println("error");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        head.next.prev = null;
        head = head.next;
    }

    public void deleteTail() {

        if (head == null) {
            System.out.println("error");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
       // Node temp = tail;
        tail.prev.next = null;
        tail = tail.prev;
    }

    public void deleteIndex(int idx) {

        if (head == null) {
            System.out.println("error");
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        if (temp.next.next == null) {
            deleteTail();
            return;
        }
        if (temp == head) {
            deleteHead();
            return;
        }
        size--;
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    // DISPLAY
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
  
    public void displayRev() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class BasicImplementations {
    public static void main(String[] args) {
        Dll d = new Dll();
        // 4 10 99 100 12
        d.insertAtEnd(4);
        d.insertAtEnd(10);
        d.insertAtEnd(99);
        d.insertAtEnd(100);
        d.insertAtEnd(12);
        d.insertAtIndex(4, -89286);
        // d.deleteHead();
        // d.deleteTail();
        d.deleteIndex(0);
        System.out.println(d.size);
        d.display();
        d.displayRev();
        Dll d2 = new Dll();
        // 41 873 999 700 212
        System.out.println();
        d2.insertAtStart(212);
        d2.insertAtStart(700);
        d2.insertAtStart(990);
        d2.insertAtStart(873);
        d2.insertAtStart(41);
        d2.insertAtIndex(3, -5465);
        d2.display();
        d2.displayRev();
    }
}