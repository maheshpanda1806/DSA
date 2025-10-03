import java.util.Arrays;

public class BoxStackingProblem {
     public static int maxHeight(int[] height, int[] width, int[] length) {
        int[][] arr = new int[6*height.length][3];
        int k = 0;
        for(int i = 0; i < height.length; i++) {
            int h = height[i];
            int w = width[i];
            int l = length[i];
            
            arr[k++] = new int[] {h, l, w};
            arr[k++] = new int[] {h, w, l};
            arr[k++] = new int[] {l, h, w};
            arr[k++] = new int[] {l, w, h};
            arr[k++] = new int[] {w, h, l};
            arr[k++] = new int[] {w, l, h};
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return b[2] - a[2];
        });
        
        int n = arr.length;
        int[] dp = new int[n];
        
        int maxHeight = 0;
       
        for(int i = 0; i < n; i++) {
             int bestPrev = 0;
            for(int j = 0; j < i; j++) {
                if(arr[i][1] > arr[j][1] && arr[i][2] > arr[j][2]){
                   bestPrev =  Math.max(bestPrev,dp[j]);
                }
            }
            dp[i] = bestPrev + arr[i][0]; 
            maxHeight = Math.max(dp[i],maxHeight);
        }
        
        return maxHeight;
    }
}
