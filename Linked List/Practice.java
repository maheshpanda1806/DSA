import java.util.*;
class ListNode {
    int val;
    ListNode next;
    public ListNode(int value) {
        this.val = value;
    }
}
// class LinkedList{
//     Node head;
//     Node tail;
//     int size = 0;

//     public void insertAtLast(int value) {
//         size++;
//         Node n = new Node(value);
//         if (head == null) {
//             head = n;
//             tail = n;
//         } else {
//             tail.next = n;
//             tail = n;
//         }
//     }
//      public void display(ListNode head) {
//         ListNode temp = head;
//         while (temp != null) {
//             System.out.print(temp.value + " ");
//             temp = temp.next;
//         }
//     }

// }


public class Practice {
    public static void main(String[] args) {
        //LinkedList ll = new LinkedList();
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(13);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(8);
        //ListNode f = new ListNode(5);
         a.next =b;
         b.next =c;
         c.next = d;
         d.next= e;
        e.next =null;
        //  f.next=c;
       display(removeNodes(a));

   //ll.display(detectCycle(a));
    }
    
    public void display(ListNode head) {
       ListNode temp = head;
       while (temp != null) {
           System.out.print(temp.val + " ");
           temp = temp.next;
       }
   }
    public static ListNode removeNodes(ListNode head) {
        ListNode current =head;
        ListNode after = head;
        List<ListNode> List = new ArrayList<>();
 
        while(current!=null){
          after=current.next;
          while(after!=null){
                if(current.val<after.val){
                    current=current.next;
                     break;
                }
               
                    after=after.next;
                
                if(after==null){
                    List.add(current);
                    current=current.next;
                }
            }
        } 
        return List.get(0);    
    }
}
