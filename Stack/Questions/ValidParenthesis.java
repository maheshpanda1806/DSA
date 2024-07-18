//package Questions;
import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false; // There's no corresponding opening bracket.
                }
                char top = st.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return st.isEmpty(); // Check if the stack is empty after processing the entire string.
    }
}
