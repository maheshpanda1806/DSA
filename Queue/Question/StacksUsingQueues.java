import java.util.*;
class StackQ{
  Queue<Integer> q = new ArrayDeque<>();
  
  void push(int val){
     q.add(val);
  }

  int peek(){
    for(int i =0;i< q.size()-1;i++){
     q.add(q.remove());
    }
    int x= q.peek();
      q.add(q.remove());
    return x;
  }
  
  int pop(){
    for(int i =0;i< q.size()-1;i++){
     q.add(q.remove());
    }
    int x= q.remove();
    return x;
  }
   public boolean empty() {
        return q.isEmpty();
    }
}
class StackQM2{
  Queue<Integer> q = new ArrayDeque<>();
  
  void push(int val){
   if(q.isEmpty()){
    q.add(val);
   }else{
      q.add(val);
     for(int i=0;i<q.size()-1;i++){
        q.add(q.remove());
     }
   }
  }

  int peek(){
    return q.peek();
  }
  
  int pop(){
   return q.remove();
  }
   public boolean empty() {
        return q.isEmpty();
    }
}
public class StacksUsingQueues {
    public static void main(String[] args) {
    StackQM2 st = new StackQM2();
    System.out.println(st.empty());
    st.push(0);
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    System.out.println(st.q);
    System.out.println(st.peek());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.q);
     System.out.println(st.empty());
    }
}
