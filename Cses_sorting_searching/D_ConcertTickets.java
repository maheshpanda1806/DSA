import java.util.*;

public class D_ConcertTickets {
    static final int MOD = 1000000007;
    //static int[] dp; 
   
    public static int[] soln(int[] price,int[] budget,int n,int m){
         int[] ans =  new int[m];
         TreeMap<Integer,Integer> mpp = new TreeMap<>();
         for(int i =0;i<n;i++) mpp.put(price[i],mpp.getOrDefault(price[i], 0)+1); 
         
         for (int i = 0; i < m; i++) {
            int val = budget[i];

            Integer key = mpp.floorKey(val);
            if(key==null) ans[i] = -1;
            else{
                ans[i] = (int)key;
                mpp.put(key,mpp.get(key)-1);
                if(mpp.get(key)==0) mpp.remove(key);
            }
         }
         return ans;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =  sc.nextInt();
        
 
        int[] price = new int[n];
        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextInt();
        }

        int[] budget = new int[m];
        for (int i = 0; i < budget.length; i++) {
            budget[i] = sc.nextInt();
        }
        
       int[] ans = soln(price,budget,n,m);
       for (int i = 0; i < ans.length; i++) {
        System.out.println(ans[i]);
       }     
        
        sc.close();
    } 
}
