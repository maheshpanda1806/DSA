import java.util.Stack;

public class previousGreatestElementM2 {
     public static void main(String[] args) {
      int [] arr= {1,2,3,8,6,4,3,5};
      int [] ans = soln(arr);
       for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
      }
      System.out.println();
      for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i]+" "); 
      }
     }  
     public static int[] soln(int[] arr){
        int [] ans = new int[arr.length];
        int n= arr.length;
        Stack<Integer> st = new Stack<>(); 
        st.push(0);
        for (int i = n-2; i >=0; i--) {
         while (!st.isEmpty() && arr[i]>arr[st.peek()]) {
            ans[st.peek()]=arr[i];
            st.pop();
         }
         st.push(i);
        }
        return ans;
     } 
}
