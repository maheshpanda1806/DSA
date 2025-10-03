
import java.util.*;
 
public class ArrayDescription {
    static final int MOD = 1000000007;
    static long[][] dp; 
        public static long rec(int[] arr,int n,int m,int level,int prev){
            //the number of arrays that can be from 
            //level to N-1 if last picked element is prev
            if(level==n) return dp[level][prev] = 1;
            
            if(prev!=101 && arr[level]!=0)if(Math.abs(arr[level]-prev)>1) return dp[level][prev] = 0;
            if(dp[level][prev]!=-1) return dp[level][prev];
            if(prev==101){
            if(arr[level]==0){
                 long ans = 0;
                 for (int i = 1; i <=m; i++) {
                    ans = (ans + rec(arr, n, m, level+1,i))%MOD;
                 }
                 return dp[level][prev]=ans;
            }else return dp[level][prev]= rec(arr,n,m,level+1,arr[level]);
        }else{
            if(arr[level]==0){
                long ans = 0;
                for (int i = 1; i <=m; i++) {
                   if(Math.abs(prev-i)<=1)ans = (ans + rec(arr, n, m, level+1,i))%MOD;
                }
                return dp[level][prev] = ans;
            }else return dp[level][prev] = rec(arr,n,m,level+1,arr[level]);
        }
        }  
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
         dp = new long[n+1][103];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(rec(arr,n,m,0,101));     
        
        sc.close();
    } 
}

