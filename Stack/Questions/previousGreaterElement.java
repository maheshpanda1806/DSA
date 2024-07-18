import java.util.Stack;

public class previousGreaterElement {
    public static void main(String[] args) {
        int [] arr= {1,2,3,8,6,4,3,5};
        int [] ans = result(arr);
         for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
          System.out.print(ans[i]+" "); 
        }
    }
    public static int[] result(int [] arr){
        int [] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        ans[0]= -1;
        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek()<arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
         st.push(arr[i]);
        }
        return ans;
    }
}
