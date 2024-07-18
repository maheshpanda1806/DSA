public class EvenOrOdd{
    public static void main(String[] args) {
      even_odd(8);
      even_odd(9);
      even_odd(0);
      even_odd(-2);
            

    }

   public static void even_odd(int n){
     if((n&1)==1){
        System.out.println("ODD");
     }
     else{
        System.out.println("EVEN");
     }
   } 
}