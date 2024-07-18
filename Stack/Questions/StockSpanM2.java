import java.util.Stack;

public class StockSpanM2 {
    public static void main(String[] args) {
        int[] arr = { 100, 80, 60, 70, 60, 95, 85 };
        int[] ans = stock(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] stock(int[] arr) {
        int[] ans = new int[arr.length]; // Initialize an array to store stock spans.
        Stack<Integer> st = new Stack<>(); // Initialize a stack to keep track of indices.

        st.push(0); // Push the index of the first day (day 0) onto the stack.
        ans[0] = 1; // The stock span for the first day is always 1.

        // Loop through the remaining days in the array.
        for (int i = 1; i < ans.length; i++) {
            // While the stack is not empty and the price of the stock at the top of the
            // stack
            // is less than the price of the current day, pop elements from the stack.
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                // If the stack is empty after popping elements, it means there are no
                // previous days with prices greater than the current day, so the stock span
                // for the current day is 1.
                ans[i] = 1;
            } else {
                // If the stack is not empty, calculate the stock span for the current day
                // as the difference between the current day's index and the index of the stock
                // in the stack.
                ans[i] = i - st.peek();
            }

            // Push the index of the current day onto the stack for future comparisons.
            st.push(i);
        }

        return ans; // Return the array containing stock spans for each day.
    }

}