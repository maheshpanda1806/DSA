public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 4, 3, 2, 0};
        int target = 3;

        int peakIndex = peakSearch(arr); // Find the index of the peak element

        // Search in the ascending portion of the array
        int inAscending = ascending(arr, target, peakIndex);

        // Search in the descending portion of the array
        int inDescending = descending(arr, target, peakIndex+1);

        // Determine the final result based on search results
        if (inDescending == -1 && inAscending != -1) {
            System.out.println(inAscending);
        } else if (inAscending == -1 && inDescending != -1) {
            System.out.println(inDescending);
        } else if (inAscending == -1 && inDescending == -1) {
            System.out.println(-1);
        } else {
            // Both ascending and descending searches found the target,
            // so choose the smaller index as the result.
            int result = Math.min(inAscending, inDescending);
            System.out.println(result);
        }
    }

    // Function to find the index of the peak element in the mountain array
    public static int peakSearch(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (e > s) {
            int mid = s + (e - s) / 2;

            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                e = mid;
            } else {
                return mid;
            }
        }
        return e;
    }

    // Function to search for the target in the ascending portion of the mountain array
    public static int ascending(int[] arr, int target, int e) {
        int s = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target > arr[mid]) {
                s = mid + 1;
            } else if (target < arr[mid]) {
                e = mid - 1;
            } else {
                // Answer found
                return mid;
            }
        }
        // Answer not found
        return -1;
    }

    // Function to search for the target in the descending portion of the mountain array
    public static int descending(int[] arr, int target, int s) {
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (target > arr[mid]) {
                e = mid - 1;
            } else if (target < arr[mid]) {
                s = mid + 1;
            } else {
                // Answer found
                return mid;
            }
        }
        // Answer not found
        return -1;
    }
}
