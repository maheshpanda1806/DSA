import java.util.*;
public class KokoEattingBananas {
public static void main(String[] args){

    }
    public int minEatingSpeed(int[] piles, int h) {
        return bs(piles,h);
    }
    public static int max(int[] arr){
        int max = 0;
        for(int i:arr){
            if(i>max) max = i;
        }
        return max;
    }
    public static boolean check(int m,int[] arr,int h){
         //checks if koko can eat all bananas in h hours if she eats with m speed
        long hours = 0;
        for(int i:arr){
             hours = hours + 10;
            if(hours>h) return false;
        }
        return true;
    }
    public static int bs(int[] arr,int h){
        int s = 0;
        int e = max(arr);
        int ans = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(check(m,arr,h)){
                ans=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;
    }
}