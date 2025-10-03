public class SwapTwoNumbers {
    public static void main(String[] args) {
     int a = 5;
     int b = 6;
     
     //using bit manipulation
     a = a^b;
     b = a^b; //b=(a^b)^b==a i.e b=a;
     a = a^b;

    //  System.out.println(a);
    //  System.out.println(b);
    
     int c = 5;
     int d = 12;

     //using +
     c = c+d;
     d = c-d; 
     c = c -d;

     System.out.println(c);
     System.out.println(d);


    }
    
}
