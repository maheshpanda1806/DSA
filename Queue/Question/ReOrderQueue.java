import java.util.ArrayDeque;
import java.util.*;
public class ReOrderQueue {
   public static void main(String[] args) {
     Queue<Integer> q = new ArrayDeque<>();
     q.add(1);
     q.add(2);
     q.add(3);
     q.add(4);
     q.add(5);
     q.add(6);
     q.add(7);
     q.add(8);
     System.out.println(reorder(q));
   }
   public static Queue<Integer> reorder( Queue<Integer> q){
   Stack<Integer> st = new Stack<>();
   for (int i = 0; i<=q.size()/2+1; i++) {
    st.push(q.remove());
   }
  
   while (!st.isEmpty()) {
    q.add(st.pop());
   } 
   
   for (int i = 0; i <=q.size()/2+1; i++) {
    st.push(q.remove());
   }
   while (!st.isEmpty()) {
    q.add(st.pop());
    q.add(q.remove());
   }
   while (!q.isEmpty()) {
     st.push(q.remove());
   }
   while (!st.isEmpty()) {
    q.add(st.pop());
   } 
   return q;
   }
}
