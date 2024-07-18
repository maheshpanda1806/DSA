import java.util.*;

public class TopKFrequentElements {
    
}class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     HashMap<Integer,Integer> mpp = new HashMap<>();
     PriorityQueue<Map.Entry<Integer,Integer>> min = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
     for(int i : nums){
        mpp.put(i,mpp.getOrDefault(i,0)+1);
     }
     for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            min.offer(entry);
            if(min.size()>k) min.poll();
        }
      int[] ans = new int[k];
      int i=0;
    while(!min.isEmpty()){
         ans[i++]= min.poll().getKey();
    }
    
   return ans;
    }
}
