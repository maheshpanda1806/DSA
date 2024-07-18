import java.util.Arrays;

class Stacks{
     int [] arr;
     Stacks(int n){
        arr = new int[n];
     }
     int idx = -1;
     boolean isEmpty(){
        if (idx==-1) {
            return true;
        }
        else{
            return false;
        }
     }
      boolean isFull(){
        if (idx==arr.length-1) {
            return true;
        }
        else{
            return false;
        }
     }
     void push(int val){
        if (isFull()) {
            System.out.println("Stack Full");
            return;
        }
        idx++;
        arr[idx] = val;
     }

     int peek(){
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        else{
         return arr[idx];
        }
     }
     int pop(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            int top = peek();
            arr[idx]=0;
            idx--;
            return top;
        }
     }
     int size(){
        return idx+1;
     }
     void display(){
        System.out.print("[");
        for (int i = 0; i <=idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
     }


}

public class ArrayImplementation {
    public static void main(String[] args) {
        Stacks st = new Stacks(10);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        st.push(10);
       System.out.println(st.size());
        st.display();
        st.pop();
        st.display();
        st.pop();
       System.out.println(st.size());
        st.display();
        st.pop();
         System.out.println(st.size());
        st.display();
        st.pop();
         System.out.println(st.size());
    }
}