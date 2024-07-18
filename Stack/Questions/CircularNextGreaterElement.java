import java.util.Arrays;
import java.util.Stack;

public class CircularNextGreaterElement {
    public static void main(String[] args) {
        int [] arr = {};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
    public static int[] nextGreaterElements(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=-1937;
        }
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * arr.length; i++) {
            int circularIndex = i % arr.length;
            while (!st.isEmpty() && arr[st.peek()] < arr[circularIndex]) {
                ans[st.pop()] = arr[circularIndex];
            }

            if (i >= arr.length)
                continue;

            st.push(circularIndex);
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==-197){
                ans[i]=-1;
            }
        }
        return ans;
    }
}

