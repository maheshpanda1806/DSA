public class Prime{
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i+" "+ IsPrime(i));
        }
    }
    static boolean IsPrime(int n){
        if (n<=1) {
           return false;
        }
        for (int i = 2; i*i <= n; i++) {
            if (n%i==0) {
                return false;
            }
        }
          return true;
    }
}