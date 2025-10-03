import java.util.HashSet;
import java.util.Set;

public class Joshephus{
   public static int powerOf2(int n){
    //if n = 2^x+ l function returns x;
    if(n==0 || n==1) return 0;
    int count = 0;
    while(n!=1){
      count++;
      n = n/2;
    }
    return count;
   }
   public static int soln(int n){
    //only if k==2
     int l = n - (int)Math.pow(2,(double)powerOf2(n));
     return 2*l+1;
   }
    public static void main(String[] args) {
        for(int i =1;i<=17;i++){
            System.out.println(powerOf2(i));
        }
    }
}
