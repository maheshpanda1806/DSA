import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortAnKSortedArr {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        sortAnKSortedArr(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortAnKSortedArr(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        int l = 0;

        for (int i = 0; i <nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                nums[l++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            nums[l++] = minHeap.poll();
        }
    }
}
