//package Questions;
import java.util.*;

public class removeConsecutiveSubsequence {
    public static void main(String[] args) {
        int [] arr = {1,2,2,2,5,5,5,7,8,8,10,11,11};
       Stack<Integer> r = remove(arr);
       while (!r.isEmpty()) {
        System.out.println(r.pop());
       }
     }
    public static Stack<Integer> remove(int[] arr){
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
             if (st.isEmpty()) {
                st.push(arr[i]);
             }
             else{
                if (st.peek()==arr[i]) {
                    st.pop();
                }
                else{
                    st.push(arr[i]);
                }
             }
            }
           
            return st;
    }
}
