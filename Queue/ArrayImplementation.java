class  QueueA {
 int front = 0;
 int rear = -1;
 int [] arr = new int[100];
 public void add(int value){
    if (isFull()) {
        System.out.println("Queue is full");
        return;
    }
    rear++;
    arr[rear]= value;
}
 public int remove(){
    if (isEmpty()) {
        System.out.println("Queue Is Empty");
        return -1;
    }
    int x = arr[front];
    front++;
    return x;
 }
 public int peek(){
     if (isEmpty()) {
        System.out.println("Queue Is Empty");
        return -1;
    }
     return arr[front];
 }
 public int size(){
    return rear-front+1;
 }
 public boolean isEmpty(){
    if (size()==0) {
        return true;
    }else{
        return false;
    }
 }
 public boolean isFull(){
    if (rear==arr.length-1) {
        return true;
    }
    else{
        return false;
    }
 }
 public void display(){
    if (isEmpty()) {
        System.out.println("NULL");
    } else {
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
 }
}
public class ArrayImplementation {
   public static void main(String[] args) {
    QueueA q = new QueueA();
    q.add(0);
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.display();
    System.out.println("Size"+ q.size());
    System.out.println();
    q.remove();
    q.display();
    System.out.println("Size"+ q.size());
   }
}