//package Questions;
import java.util.*;
// Initialize two arrays: ans to store the greatest elements to the right, and s (a stack) to keep track of elements.
// Set the last element of ans to -1 because there are no elements to the right of it.
// Push the last element of the input array arr onto the stack s for processing.
// Iterate through arr in reverse order (from the second-to-last element to the first element).
// Inside the loop, pop elements from the stack while they are smaller than the current element in arr. This identifies the first greater element to the right of the current element.
// If the stack becomes empty during this process, it means no greater element to the right exists, so set ans[i] to -1.
// If the stack is not empty after the while loop, assign the top element of the stack (the first greater element to the right) to ans[i].
// Push the current element onto the stack for processing in the next iteration.
// Continue this process until all elements in arr are processed.
// After the loop, the ans array contains the greatest elements to the right of each element in the input array arr.
public class NextGreatestElement {
    public static void main(String[] args) {
      int [] arr= {1,2,3,8,6,4,3,5};
      System.out.println(Arrays.toString(arr));
      System.out.println(Arrays.toString(greatest(arr)));
    }
    public static int[] greatest(int [] arr){
        int [] ans= new int[arr.length];
        Stack<Integer> s= new Stack<>();
        ans[arr.length-1]=-1;
        s.push(arr[arr.length-1]);
        for (int i = ans.length-2; i >=0; i--) {
                while (!s.isEmpty() && s.peek()<arr[i]) {
                    s.pop();
                }
                if(s.isEmpty()){
                    ans[i]=-1;
                }
                else{
                ans[i] = s.peek();
                }
                s.push(arr[i]);
            }
        
        return ans;
    }
}
