public class SumOfDigit {
    public static void main(String[] args) {
        int a = 1734;
      System.out.println(sum(a));
    }

    public static int sum(int n){
        if (n==0) {
            return 0;
        } 
         return n%10 + sum(n/10);
    }
}
