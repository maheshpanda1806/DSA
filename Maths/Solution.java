import java.util.*;
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution{
    public static void main(String [] args){
      ListNode a = new ListNode(1);
      ListNode b = new ListNode(2);
      ListNode c = new ListNode(1);
      ListNode d = new ListNode(1);
      //ListNode e = new ListNode(1);
       a.next=b;
       b.next=c;
       c.next=d;
       d.next=null;
      // e.next=null;
       System.out.println(isPalindrome(a));
    }
    public static ListNode rev(ListNode head){
      ListNode before = null;
      ListNode current =head;
      ListNode after =head;
      while (current!=null) {
        after=after.next;
        current.next =before;
        before=current;
        current=after;
      }
      return before;
    }
    public static void display(ListNode head){
      ListNode temp = head;
      while(temp!=null){
        System.out.println(temp.val);
        temp=temp.next;
      }
    }
    public static boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) {
          return true; // An empty list or a single node is a palindrome.
      }
  
      // Find the middle of the linked list.
      ListNode fast = head;
      ListNode slow = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
  
      // Reverse the second half of the linked list.
      slow.next = rev(slow.next);
  
      // Compare the first half with the reversed second half.
      ListNode p1 = head;
      ListNode p2 = slow.next;
      while (p2 != null) {
          if (p1.val != p2.val) {
              return false;
          }
          p1 = p1.next;
          p2 = p2.next;
      }
  
      return true;
  }
  
}