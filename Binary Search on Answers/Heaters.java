import java.util.*;

public class Heaters {
    class Solution {
    public int findRadius(int[] hs, int[] ht) {
        Arrays.sort(hs);
        Arrays.sort(ht);
        int s = 0;
        int e = (int)1e9;
        int ans = -1;

        while(s<=e){
            int m = s+(e-s)/2;
            if(check(hs,ht,m)){
                ans = m;
                e=m-1;
            }else s = m+1;
        }
        return ans;
    }
    //check func is actually similiar to first question asked in tpo's first test 
    //two pointer approach we could have also used TreeMap and the overall
    // complexity would've been N(logN)^2
    public boolean check(int[] hs, int[] ht,int m){
        int i = 0;
        int j = 0;
        
        while(i<hs.length && j<ht.length){
           if(hs[i]<=ht[j]+m && hs[i]>=ht[j]-m){
             i++;
           }else j++;
        }  
        if(i==hs.length) return true;
        return false;
    }
}
}
