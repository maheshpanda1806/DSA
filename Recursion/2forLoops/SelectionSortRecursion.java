import java.util.Arrays;

public class SelectionSortRecursion {
    public static void main(String[] args) {
        int[] arr = {2, 39, 4, 8, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int greatestInArray(int[] arr, int e) {
        return greatestInArray(arr, 0, 0, e, 0);
    }

    public static int greatestInArray(int[] arr, int i, int s, int e, int ans) {
        if (i == e + 1) {
            return ans;
        }
        if (arr[i] > arr[ans]) {
            ans = i;
        }
        return greatestInArray(arr, i + 1, s, e, ans);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr) {
        sort(arr, arr.length - 1);
    }

    public static void sort(int[] arr, int end) {
        if (end == 0) {
            return;
        }
        swap(arr, greatestInArray(arr, end), end);
        sort(arr, end - 1);
    }
}
