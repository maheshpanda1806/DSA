import java.util.*;
public class ReverKelements {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
       System.out.println(rev(q,3));
    }
    public static Queue<Integer> rev(Queue<Integer> q,int k){
        Queue<Integer> q2 = new ArrayDeque<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while (!q.isEmpty()) {
            q2.add(q.remove());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        while (!q2.isEmpty()) {
            q.add(q2.remove());
        }
        return q;
    }
}
