import java.util.*;

// Initialize two arrays: ans to store the solutions, and st (a stack) to keep track of indices.
// Push the index 0 onto the stack st for processing.
// Start a loop from index 1 to the end of the array, which iterates through the input array arr.
// Inside the loop, compare the current element in arr[i] with the element at the index stored at the top of the stack st.
// If the element at index arr[st.peek()] is smaller than the current element arr[i], it means arr[i] is the solution for the element at index st.peek() because arr[i] is the first element to the right that is greater.
// In this case, assign arr[i] to the ans array at the index st.peek() to store the solution.
// After storing the solution, pop the index from the stack st because we've found the solution for it.
// Push the current index i onto the stack to continue processing it.
// Continue this process for all elements in the input array.
// After the loop completes, the ans array will contain the solutions for each element, which represent the first greater element to the right of that element. If no greater element exists to the right, the corresponding position in ans will remain 0 (as initially set), which can be adjusted as needed.
public class NextGreatestElementM2 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 4, 6, 0 };
        int[] res = soln(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    public static int[] soln(int[] arr) {
        int[] ans = new int[arr.length];
        // Initialize two arrays: ans to store the solutions, and st (a stack) to keep
        // track of indices.
        // Push the index 0 onto the stack st for processing.
        // Start a loop from index 1 to the end of the array, which iterates through the
        // input array arr.
        // Inside the loop, compare the current element in arr[i] with the element at
        // the index stored at the top of the stack st.
        // If the element at index arr[st.peek()] is smaller than the current element
        // arr[i], it means arr[i] is the solution for the element at index st.peek()
        // because arr[i] is the first element to the right that is greater.
        // In this case, assign arr[i] to the ans array at the index st.peek() to store
        // the solution.
        // After storing the solution, pop the index from the stack st because we've
        // found the solution for it.

        Stack<Integer> st = new Stack<>(); // Create an empty stack to keep track of indices
        st.push(0); // Push the index 0 onto the stack to start processing
        for (int i = 1; i < ans.length; i++) { // Start a loop from index 1 to the end of the array
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                // While the stack is not empty and the element at arr[st.peek()] is smaller
                // than the current element arr[i],
                // it means arr[i] is the solution for the element at index st.peek() because
                // arr[i] is the first greater element to the right.

                ans[st.peek()] = arr[i]; // Assign arr[i] as the solution for the element at index st.peek()
                st.pop(); // Pop the index from the stack because we've found the solution for it
            }

            st.push(i);
         // Push the current index i onto the stack to continue processing it
        }

        // Continue this process for all elements in the input array.

        // After the loop completes, the ans array will contain the solutions for each
        // element, representing the first greater element to the right of that element.
        // If no greater element exists to the right, the corresponding position in ans
        // will remain 0 (as initially set), which can be adjusted as needed.
        return ans;
    }
}
