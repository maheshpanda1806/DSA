public class Sqrt {
    public static void main(String[] args) {
     System.out.println(getSqrt(81));//8.83176087
    }
    public static double getSqrt(int n){
     double ans = (double) BeforeDecimal(n);
    
     for (int i = 0; i < 10; i++) {
        while (ans*ans<=n){
            ans =  ans+ Math.pow(10,-(i+1));
        }
        ans = ans -Math.pow(10,-(i+1));
     }
     return ans;
    }

    public static int BeforeDecimal(int n){
        int s=0;
        int e= n;
        int m;
        while(e>=s){
            m= s +(e-s)/2;
            if(m*m==n){
                return m;
            }

            if(m*m<n){
                s= m+1;
            }
             else if(m*m>n){
                e= m-1;
            }
        }
        return e;
    }
}
