import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int leftIndex = 0;
        int rightIndex = n - 1;
        
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        
        // Fill both queues initially
        for (int i = 0; i < candidates && leftIndex <= rightIndex; i++) {
            leftQueue.offer(costs[leftIndex++]);
            if (leftIndex <= rightIndex) {
                rightQueue.offer(costs[rightIndex--]);
            }
        }
        
        long totalCost = 0;
        
        for (int i = 0; i < k; i++) {
            if (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                if (leftQueue.peek() <= rightQueue.peek()) {
                    totalCost += leftQueue.poll();
                } else {
                    totalCost += rightQueue.poll();
                }
            } else if (!leftQueue.isEmpty()) {
                totalCost += leftQueue.poll();
            } else {
                totalCost += rightQueue.poll();
            }
            
            // Refill the queues if possible
            if (leftQueue.size() < candidates && leftIndex <= rightIndex) {
                leftQueue.offer(costs[leftIndex++]);
            }
            if (rightQueue.size() < candidates && leftIndex <= rightIndex) {
                rightQueue.offer(costs[rightIndex--]);
            }
        }
        
        return totalCost;
    }
}
