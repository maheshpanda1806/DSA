public class Basic{
public static void main(String[] args) {
   System.out.println(fibo(9));
print(5);
}
public static void print(int n){
   if(n==0){
      return;
   }
  
   print(n-1);
   System.out.println(n);
}

public static  int fibo(int n){
   if (n==1) {
    return 1;
   }

   else if (n==0) {
    return 0;
   } 
   else{
    int ans = (fibo(n-1)+ fibo(n-2));
    return ans;
   }
}
}