package Concepts;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 5, 9, 11, 12, 14, 20, 36, 48 };
        int[] arr2 = { 48, 36, 20, 14, 12, 11, 9, 5, 4, 2 };

        System.out.println(search(arr, 11, arr[0] <= arr[arr.length - 1]));
        System.out.println(search(arr, 12, arr[0] <= arr[arr.length - 1]));
        System.out.println(search(arr, 41, arr[0] <= arr[arr.length - 1]));
        System.out.println();
        System.out.println();
        System.out.println(search(arr2, 9,  arr2[0] <= arr2[arr.length - 1]));
        System.out.println(search(arr2, 12, arr2[0] <= arr2[arr.length - 1]));
        System.out.println(search(arr2, 48, arr2[0] <= arr2[arr.length - 1]));
    }

    public static int search(int[] arr, int target, boolean isAscending) {
        if (isAscending) {
            int s = 0;

            int e = arr.length - 1;

            while (e >= s) {
                int mid = s - (s - e) / 2;

                if (target > arr[mid]) {
                    s = mid + 1;

                } else if (target < arr[mid]) {
                    e = mid - 1;
                } else {
                    // answer found
                    return mid;
                }
            }
            // answer not found
            return -1;
        } else {
            int s = 0;

            int e = arr.length - 1;

            while (e >= s) {
                int mid = s - (s - e) / 2;
                if (target > arr[mid]) {
                    e = mid - 1;

                } else if (target < arr[mid]) {
                    s = mid + 1;
                } else {
                    // answer found
                    return mid;
                }
            }
            // answer not found
            return -1;
        }
    }
}
