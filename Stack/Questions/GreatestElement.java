import java.util.Stack;

public class GreatestElement {
    public static void main(String[] args) {
        int[]arr = {10,9,11,12,15,13,12,14};
        Stack<Integer> rt= soln(arr);
          while (rt.size()>1) {
           rt.pop();
       }
     System.out.println(rt.peek());
    }
    public static Stack<Integer> soln(int [] arr){
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty()  && arr[i]>st.peek()) {
                st.pop();
            }
            st.push(arr[i]);
        }
        return st;
    } 
}
