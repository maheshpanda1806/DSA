import java.util.*;
 
public class LISBS {
    static final int MOD = 1000000007;
    //static int[] dp; 
    static int soln(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
       // dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
           if(arr[i]>temp.get(temp.size()-1)) temp.add(arr[i]);
           else{
            int idx = Collections.binarySearch(temp,arr[i]);
             if(idx<0){
                 int ans =  -(idx+1);
                 temp.set(ans, arr[i]);
             }
           }
           //dp[i] = temp.size();
        }
        return temp.size();
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //dp = new int[n];

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
       System.out.println(soln(arr, n));     
        
        sc.close();
    } 
}