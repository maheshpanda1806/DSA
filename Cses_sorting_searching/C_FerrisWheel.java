import java.util.*;
public class C_FerrisWheel {
   
 
    static final int MOD = 1000000007;
    //static int[] dp; 
   
    public static int soln(int[] arr,int n,int x){
        Arrays.sort(arr);
        int i =0;
        int j = n-1;
        int count = 0;
        while (i<=j) {
            if(i==j){
                count++;
                i++;
                j--;
            } 
            else{
            if(arr[i]+arr[j]<=x){
                count++;
                i++;
                j--;
            }else{
                count++;
                j--;
            }
            }
        }
        return count;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =  sc.nextInt();
        
 
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
       System.out.println(soln(arr, n,m));     
        
        sc.close();
    } 
}

