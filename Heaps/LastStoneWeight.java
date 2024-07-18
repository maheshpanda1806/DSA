
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];

        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : stones){
            max.offer(i);
        }
        while(max.size()!=0){
         if(max.size()==1){
            return max.poll();
        }
        int a = max.poll();
        int b = max.poll();
        max.offer((int)Math.abs(a-b));
        
        }
        return 0;

    }
}