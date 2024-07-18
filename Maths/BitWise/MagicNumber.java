public class MagicNumber {
    public static void main(String[] args) {
       for (int i = 0; i <=10; i++) {
         System.out.println(soln(i));
       }
    }
    
    public static int soln(int n){
          int i=1;
         int sum=0;
        while (n!=0){
            sum += (n&1)*Math.pow(5, i);
            n=n>>1;
            i++;
        }
        return sum;
    }
}
