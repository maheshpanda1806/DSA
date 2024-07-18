import java.util.*;

public class Basic{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
       // Stack<Integer> st_final = new Stack<>();
        st.push(0);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        
        System.out.println("Orginal "+ st);
        reverseRecursion(st);
        System.out.println("after "+ st);
       
    }
    //MOVING FROM ONE STACK TO ANOTHER
    public static void move(Stack<Integer> st,Stack<Integer> st_final){
        Stack<Integer> temp = new Stack<>();
    
        System.out.print("original");
        System.out.println(st);

        while(!st.isEmpty()){
       temp.push(st.pop());
        } System.out.print("temp: ");
                System.out.println(temp);

       while(!temp.isEmpty()){
       st_final.push(temp.pop());
        }
        System.out.print("final: ");
         System.out.println(st_final);

    }

    //INSERT AT ANY INDEX
    public static void InsertAt(Stack<Integer> st,int idx,int val){
        Stack<Integer> temp = new Stack<>();
      for (int i = 0; i < idx; i++) {
        temp.push(st.pop());
      }
      st.push(val);
      while(!temp.isEmpty()){
        st.push(temp.pop());
      }
    }
    //DisplayRevRecursively
    public static void displayRevRecursively(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
      System.out.print(st.peek()+ " ");
      st.pop();
      displayRevRecursively(st);
    }
    //REVERSE ITERATIVE
    public static void reverseStack(Stack<Integer> st){
        Stack<Integer> temp1= new Stack<>();
        Stack<Integer> temp2= new Stack<>();
        
        while(!st.isEmpty()){
            temp1.push(st.pop());
        }
        while(!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }
        while(!temp2.isEmpty()){
            st.push(temp2.pop());
        }
    }
    //REVERSE USING RECURSION
    public static void reverseRecursion(Stack<Integer> st){
        if (st.size()==1) {
            return;
        }
        int top =st.pop();
        reverseRecursion(st);
        pushAtBottom(st,top);
    }
    public static void pushAtBottom(Stack<Integer> st, int top){
        Stack<Integer> rt = new Stack<>();
        while (!st.isEmpty()) {
            rt.push(st.pop());
        }
        st.push(top);
        while (!rt.isEmpty()) {
            st.push(rt.pop());
        }
    }
}