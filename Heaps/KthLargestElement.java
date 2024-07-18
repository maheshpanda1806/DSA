import java.util.*;
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i =0;i<nums.length;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k) minHeap.poll();
        }
        return minHeap.poll();
    }

    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());//maxheap
        
        for(int i =0;i<nums.length;i++){
            heap.add(nums[i]);
            if(heap.size()>k) heap.poll();
        }
        return heap.poll();
        
    }
}
