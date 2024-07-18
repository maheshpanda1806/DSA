import java.util.Stack;

class DataType{
    int val;
    int index;
    DataType(int val,int index){
        this.val= val;
        this.index=index;
    }
}

public class StockSpan{
    public static void main(String[] args) {
        int [] arr= {100,80,60,70,60,95,85};
        int [] ans = stock(arr);
         for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
          System.out.print(ans[i]+" "); 
        }
    }
    public static int[] stock(int [] arr){
        int [] ans= new int[arr.length];
        Stack<DataType> st = new Stack<>();
        ans[0]=1;
        st.push(new DataType(arr[0],0));
        for (int i = 1; i < ans.length; i++) {
            while (!st.isEmpty() && st.peek().val<arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i]=1;
            }
            else{
                ans[i]=i-st.peek().index;
            }
            st.push(new DataType(arr[i],i));
        }
        return ans;
    }
}