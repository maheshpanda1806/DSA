import java.util.*;
public class ReverseQueue{
   public static void main(String[] args) {
    Queue<Integer> q = new ArrayDeque<>();
      q.add(0);
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
     System.out.println(rev(q));
   }
   public static Queue<Integer> rev(Queue<Integer> q){
    Stack<Integer> st = new Stack<>();
    while (!q.isEmpty()) {
        st.push(q.remove());
    }
    while (!st.isEmpty()) {
        q.add(st.pop());
    }
    return q;
   }
}