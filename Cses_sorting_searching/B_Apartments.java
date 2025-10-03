import java.util.*;

public class B_Apartments{
    static final int MOD = 1000000007;
   
    public static int soln(int[] aprtsize,int[] limit,int n,int m ,int x){
        int ans = m;
        TreeMap<Integer,Integer> mpp = new TreeMap<>();
        for (int i = 0; i < aprtsize.length; i++) {
            mpp.put(aprtsize[i],mpp.getOrDefault(aprtsize[i], 0)+1);
        }
        for (int i = 0; i < limit.length; i++) {
            int val = limit[i];
            int ll = val-x;
            int ul = val+x;
            Integer key = mpp.ceilingKey(ll);
            if(key!=null){
                if((int)key>ul) key = null;
            }
            if(key==null) ans--;
            else{
                mpp.put(key,mpp.get(key)-1);
                if(mpp.get(key)==0) mpp.remove(key);
            }
        }
        return ans;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        
        int[] aprtsize = new int[n];
        int[] limit = new int[m];
        for (int i = 0; i < n; i++) {
           aprtsize[i]=sc.nextInt();
        }    
        for (int i = 0; i <m; i++) {
            limit[i] = sc.nextInt();
        }
        int ans = soln(aprtsize,limit,n,m,x);
        System.out.println(ans);
        
        sc.close();
    } 
}
