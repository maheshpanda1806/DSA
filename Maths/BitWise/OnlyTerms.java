public class OnlyTerms {
    public static void main(String[] args) {
        int [] arr= {1,1,2,2,3,4,5,6,3,4,5};
        System.out.println(only(arr));
    }
    public static int only(int [] arr){
        int ans =0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans^arr[i]);
        }
        return ans;
    }
}
