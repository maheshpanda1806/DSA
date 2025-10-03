import java.util.*;
 
public class N_Towers {
    //static final int MOD = 1000000007;
    
   
    public static void soln(int[]arr, int n){
       TreeMap<Integer,Integer> mpp = new TreeMap<>();
 
       for(int i=0;i<n;i++){
        Integer key = mpp.higherKey(arr[i]);
        if(key==null){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }else{
            mpp.put(key,mpp.get(key)-1);
            if(mpp.get(key)==0) mpp.remove(key);
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }
       }
        int ans = 0;
        for (Integer key: mpp.keySet()) {
            ans = ans + mpp.get(key);
        }
        System.out.println(ans);
     }     
    
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
           arr[i]=sc.nextInt();
        }    
        
        soln(arr,n);       
        sc.close();
    } 
}