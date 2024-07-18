class   QueueCA{
    int[] arr = new int[5];
    int rear =-1;
    int front=-1;
    int size=0;
    void enQueue(int val){
        if ((rear+1)%arr.length==front) {
            System.out.println("FULL");
            return;
        }
        if (rear==-1 && front==-1){
            rear=0;
            front=0;
            arr[rear]=val;
        }else{
            rear= (rear+1)%arr.length;
            arr[rear]=val;
        }
        size++;
    }
    int deQueue(){
        if (rear==-1 && front==-1) {
            System.out.println("EMPTY");
            return -1;
        }
        else if(rear==front){
        size--;
        int x = arr[front];
       // front= (front+1)%arr.length;
         rear=-1;
        front =-1;
        return x;
        }
        else{
        size--;
        int x = arr[front];
        front= (front+1)%arr.length;
        return x;
    }   
  }
  void display(){
    if (rear==-1 && front==-1) {
        System.out.println("[]");
     
    }else{
      int i=front;
      System.out.print("[");
      while (i!=rear) {
        System.out.print(arr[i]+ " ");
        i=(i+1)%arr.length;
      }
      System.out.print(arr[rear]);
      System.out.print("]");
      System.out.println();
    }
  }
}

public class CircularArrya {
    public static void main(String[] args) {
    QueueCA q = new QueueCA();
    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);
    q.display();
    q.deQueue();
    q.display();
    q.enQueue(6);
    q.deQueue();
    q.display();
    }
}