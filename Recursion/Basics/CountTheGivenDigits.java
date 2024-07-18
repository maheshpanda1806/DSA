public class CountTheGivenDigits{
         static int count =0;
     public static void counting(int n,int m){
       if(n==0){
        return;
       }
        int b = n%10;
        if(b==m){
            count++;
        }
        counting(n/10,m);
        }
        public static void main(String [] ags){
        int n = 1112033;
        counting(n,3);
        System.out.println(count);
    }
}
