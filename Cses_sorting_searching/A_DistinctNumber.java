import java.util.*;
public class A_DistinctNumber{
      static final int MOD = 1000000007;
     
    public static int soln2(int[] arr,int n){
        HashSet<Integer> st = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }
        return st.size();
    }
    public static int soln(int[] arr,int n){
        int prev = -1;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(prev!=arr[i]){
                count++;
                prev=arr[i];
            }
        }
        return count;
    }
    
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
 
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
       System.out.println(soln2(arr, n));     
        
        sc.close();
    } 


}