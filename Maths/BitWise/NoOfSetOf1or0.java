public class NoOfSetOf1or0 {
    public static void main(String[] args) {
        int n =9;
    System.out.println(soln(n));
    }
    public static int soln(int n){
        int c0=0;
        int c1=0;

        while (n!=0) {

            if((n&1)==1){
                c1++;
            }

            if ((n&1)==0){
                c0++;
            }
            n= (n>>1);
          
        }
          if (c0<=c1) {
                return c0;
            } else {
                return c1;
            }
    }
}
