public class PaintersPartition {
    public static void main(String[] args) {
        
      } //check is we can complete painting the all walls in max  minutes using <=k painters?
    public static int check(int[]arr, int k, int minutes){
        int lastTimeRem = minutes;
        int painterCount=k;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=lastTimeRem){
                lastTimeRem-=arr[i];
            }
        }
    }
    public static int bs(int[] wall,int k){
        long s=0,e=sum(arr);
        int ans=-1;
        while(e>=s){
            int m = (s+e)>>1;
            if(check(arr,k,m)==1){
                ans=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;
    }
    
}
