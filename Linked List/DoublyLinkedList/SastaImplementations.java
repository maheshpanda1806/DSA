class Node{
    Node prev;
    int val;
    Node next;
    Node(int val){
        this.val = val;
    } 
}
 class dll{
     public  void ifHead(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public  void ifTail(Node tail){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.prev;
        }
        System.out.println();
    }

    public  void ifAnyindex(Node idx){
        Node temp = idx;
       while(temp.prev!=null){
            temp=temp.prev;
        }
        ifHead(temp);
        System.out.println();
    }
 }
public class SastaImplementations {
    public static void main(String[] args) {
       // 4 10 99 100 12
       dll l = new dll();
        Node a = new Node(4);
         Node b = new Node(10);
         Node c = new Node(99);
          Node d = new Node(100);
           Node e = new Node(12); 
 
           a.next=b;

           b.prev =a;
           b.next=c;

           c.prev =b;
           c.next=d;

           d.prev =c;
           d.next=e;
        
           e.prev =d;
         l.ifHead(a);
         l.ifTail(e);
         l.ifAnyindex(d);

    }
}