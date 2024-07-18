import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] nums, int k) {
        // HashMap to store index and distance
        HashMap<Integer, Double> mpp = new HashMap<>();
        
        // PriorityQueue (max-heap) to store entries based on distance
        PriorityQueue<Map.Entry<Integer, Double>> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getValue(), a.getValue())); // Comparator for max-heap
        
        // Calculate distance for each point and store in HashMap
        for (int i = 0; i < nums.length; i++) {
            double distance = Math.sqrt((double)nums[i][0] * nums[i][0] + (double)nums[i][1] * nums[i][1]);
            mpp.put(i, distance);
        }

        // Add entries to maxHeap and maintain heap size <= k
        for (Map.Entry<Integer, Double> entry : mpp.entrySet()) {
            maxHeap.add(entry);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare result array
        int[][] result = new int[k][2];
        int i = 0;

        // Populate result array from maxHeap
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Double> entry = maxHeap.poll();
            int idx = entry.getKey();
            result[i][0] = nums[idx][0];
            result[i][1] = nums[idx][1];
            i++;
        }

        return result;
    }

}
class Solution1 {
    private class Node {
        private int diff;
        private int index;

        public Node(int index, int diff) {
            this.diff = diff;
            this.index = index;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> (a.diff == b.diff) ? b.index - a.index : b.diff - a.diff
        );

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Node(i, Math.abs(x - arr[i])));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(arr[pq.poll().index]);
        }

        Collections.sort(ans);
        return ans;
    }
}
