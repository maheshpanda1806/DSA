import java.util.Arrays;
import java.util.Scanner;

public class G_StickLength {
     public static void soln(int[] arr,int n){
            Arrays.sort(arr);
            
            if(arr.length%2!=1){
              int n1=arr[(n/2)+1];
              int n0 = arr[n/2];

              long score0 = 0;
              long score1 = 0;

              for (int i = 0; i < arr.length; i++) {
                score0 = score0 + Math.abs(arr[i]-n0);
                score1 = score1 + Math.abs(arr[i]-n1);
              }
              System.out.println(Math.min(score1, score0));
            }else{
                int n0 = arr[n/2];
                long score0 = 0;

                for (int i = 0; i < arr.length; i++) {
                  score0 = score0 + Math.abs(arr[i]-n0);
                }
                System.out.println(score0);
            }
        }
       
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
      
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
           arr[i]=sc.nextInt();
        }
         soln(arr,n);
        //System.out.println(ans);    
        sc.close();
    }
}
