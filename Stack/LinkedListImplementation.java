class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class LlStacks{
    ListNode head=null;
    
    boolean isEmpty(){
        if (head==null) {
            return true;
        } else {
            return false;
        }
    }

    void push(int val){
        ListNode temp = new ListNode(val);
        temp.next= head;
        head = temp;
    }
    int pop(){
      if (head==null) {
        System.out.println("Is Empty");
         return -1;
      }
      int top = head.val;
      head = head.next; 
      return top;
    }
    int peek(){
        return head.val;
    }
    void display(){
        if(head==null){
            System.out.println("stack empty");
            return;
        }
        ListNode temp = head;
        while(temp!=null){
          System.out.print(temp.val+ " ");
          temp =temp.next;
        }
        System.out.println();
    }
}
public class LinkedListImplementation {
    public static void main(String[] args) {
        LlStacks st = new LlStacks();
        st.push(1);
        st.push(0);
        st.push(5);
        st.display();
        System.out.println(st.pop());
        st.display();
        System.out.println(st.peek());
    }
}
