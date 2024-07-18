import java.util.*;
public class RemoveTeStonesTiMinimize {
    
}
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> max= new PriorityQueue<>(Comparator.reverseOrder());
        int sum =0;
        for(int i =0;i<piles.length;i++){
            max.offer(piles[i]);
            sum+=piles[i];
        }
        for(int i = 0;i<k;i++){
           int temp = max.poll();
           sum-=(int)Math.floor(temp/2);
           temp= temp - (int)Math.floor(temp/2);
           
           max.offer(temp);
        }
        // int sum = 0;
        //  while(!max.isEmpty()){
        //     sum+=max.poll();
        //  }
         return sum;
    }
}
