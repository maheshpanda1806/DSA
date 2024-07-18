import java.util.ArrayDeque;
import java.util.*;

public class NegativeKwindow {
 public static void main(String[] args) {
    long [] arr = {12, -1, -7, 8, -15, 30, 16, 28};
    System.out.println(Arrays.toString(opt(arr, arr.length, 3)));
 }
 public static long[] opt(long []arr,int N, int k){
    long[] ans = new long[N-k+1];
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
        if (arr[i]<0) {
            q.add(i);
        }
    }
    for (int i = 0; i <N-k+1 ; i++) {
        if(q.size()==0) ans[i] =0;
        if (q.size()>0 && q.peek()<i) q.remove();
        
        if (q.size()>0 && q.peek()<i+k-1) ans[i] = arr[q.peek()];
        else ans[i] =0;
    
    }
     return ans;
    }
   
 
 public static long[] bruteforce(long []arr,int N, int k){
    //t.c O(k*n)
   long[] ans = new long[N-k+1]; 
   int m =0;
   for (int i = 0; i <= arr.length-k; i++) {
    for (int j = 0; j < k; j++) {
        if (arr[i+j]<0) {
            ans[m]= arr[i+j];
            break;
        }
    }
    m++;
   }
    return ans;
 }

}