public class iThBit {
    public static void main(String[] args) {
        soln(5, 1);
    }
    public static void soln(int n,int m){
      if ((n&(1<<(m-1)))==0) {
        System.out.println("The ith bit is 0");
      }
      else{
         System.out.println("The ith bit is 1");
      }
    }
}
