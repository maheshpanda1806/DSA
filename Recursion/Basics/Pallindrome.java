public class Pallindrome {
    public static void main(String[] args) {
        int n = 12021;
        System.out.println(n == reverse(n));
    }
    
    public static int reverse(int n){
        if(n == 0){
            return 0;
        }
        return (int) (n%10*Math.pow(10.0d,(int) Math.log10(n)) + reverse(n/10));
    }
    
}
