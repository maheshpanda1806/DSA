class Solution {
    int[][] dp;
    public int minSteps(int n) {
        if(n==1) return 0;
         dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }        
    }
         return rec(n,1,0);
    }
    public int rec(int n,int al,int cp){
        //function that gives min steps to print exactly n A 
        //if al no of A's are already printed on the screen 
        //cp is the no of A's copied last time

        //prunining
        if(al>n) return (int)1e8;
        //base case
        if(n==al) return 0;

        if (dp[al][cp] != -1) {
            return dp[al][cp];
        }
         
       
        int copyAll = (int)1e8;
        if(cp!=al) copyAll = 1 + rec(n,al,al);
          int paste = (int)1e8;
        if(al + cp<=n && cp!=0) paste = 1 + rec(n,al+cp,cp);

       

        return dp[al][cp] = Math.min(copyAll,paste);
    }
}