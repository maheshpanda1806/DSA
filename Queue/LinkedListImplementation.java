//import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode (int val){
        this.val=val;
     } 
}
class QueueLL{
    ListNode front=null;
    ListNode rear =null;
    int size =0;
    
    void enQueue(int val){
        size++;
        ListNode temp = new ListNode(val);
        if (rear==null) {
            rear=temp;
            front = temp;
        }else{
            rear.next= temp;
            rear= temp;
        }
    }
    int deQueue(){
        int x;
       if (size==0) {
        System.out.println("Already Empty");
        return -1;
       }else{
        size--;
         x= front.val;
        front =front.next;
       }
       if (front==null) {
        rear =null;
       }
    return x;
    }

    int peek(){
        if(size!=0) {
        System.out.println("Empty");
        return -1;
        }
        else return front.val;
    }
    boolean isTrue(){
          if(size!=0) return false;
        else return true;
    }
   
    void display(){
        if(size==0){
        System.out.println("[]");
        return;
    }
       ListNode temp= front;
       System.out.print("[");
       while(temp!=rear.next){
        System.out.print(temp.val+ " ");
        temp=temp.next;
       }
       System.out.println("]");
       System.out.println();
    }
}
public class LinkedListImplementation {
    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        q.display();
        q.deQueue();
        q.display();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.display();
        q.enQueue(0);
        q.display();
    }
}
