import java.util.Stack;

class QueueS{
   Stack<Integer> st = new Stack<>();
   Stack<Integer> temp=new Stack<>();
   
   void add(int x){
   st.push(x);
   }

   int remove(){
    while (!st.isEmpty()) {
        temp.push(st.pop());
    }
    int x= temp.pop();
    while (!temp.isEmpty()) {
        st.push(temp.pop());
    }
    return x;
   }

   int peek(){
     while (!st.isEmpty()) {
        temp.push(st.pop());
    }
   int x= temp.peek();
    while (!temp.isEmpty()) {
        st.push(temp.pop());
    }
    return x;
   }
   boolean empty(){
    return st.isEmpty();
   }
}
public class QueuesUsingStacks {
    public static void main(String[] args) {
        QueueS q = new QueueS();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.st);
        System.out.println(q.remove());
        System.out.println(q.st);
        System.out.println(q.peek());
    }
}
