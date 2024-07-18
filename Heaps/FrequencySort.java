import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        // Create a PriorityQueue (min-heap) to sort elements by their frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            // Sort by frequency first
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            }
            // If frequencies are the same, sort by the element value in descending order
            return b.getKey() - a.getKey();
        });

        // Add all entries from the HashMap to the PriorityQueue
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            minHeap.offer(entry);
        }

        // Create an array to store the result
        int[] result = new int[nums.length];
        int i = 0;

        // Process the PriorityQueue
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            int frequency = entry.getValue();
            int value = entry.getKey();
            // Add the element to the result array 'frequency' number of times
            for (int j = 0; j < frequency; j++) {
                result[i++] = value;
            }
        }

        return result;
    }
}
