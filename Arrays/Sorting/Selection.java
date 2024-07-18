import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 6, 1, 8, 12, -90, -58 };
        sort(arr, false);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, boolean WithMax) {
        if (WithMax) {
            for (int i = 0; i < arr.length; i++) {
                int temp = arr[max(arr, arr.length - i,WithMax)];
                arr[max(arr, arr.length - i,WithMax)] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        } else {
            for (int i = 0; i <=arr.length-1; i++) {
                int temp = arr[max(arr, i,WithMax)];
                arr[max(arr, i,WithMax)] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static int max(int[] arr, int n ,boolean WithMax) {
       if (WithMax) {
         int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[ans]) {
                ans = i;
            }

        }
        return ans;
       }

       else{
        int ans = arr.length-1;
        for (int i = n; i <=arr.length-1; i++) {
            if (arr[i] < arr[ans]) {
                ans = i;
            }
        }
        return ans;

    }
    }
    public static int IndexNo(int[] arr, int n,boolean WithMax) {
        if (WithMax) {
            
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == max(arr, n,WithMax)) {
                ans = i;
            }
        }
        return ans;
        }
        else{
            int ans = -11;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] == max(arr, n,WithMax)) {
                ans = i;
            }
        }
        return ans;
        }
    }
}
