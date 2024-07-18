
public class MaximumPointsYouCanObtainfromCards {
    public static void main(String[] args) {
      int [] arr = {6,2,3,4,7,2,1,7,1};
      int [] arr2 = {1,2,3,4,5,6,1};

      int k = 4;
      maxPointsScored(arr,k);
    }
    
    public static void maxPointsScored(int [] arr, int k){
        int leftsum = 0;
        int rightsum = 0;
        for (int i = 0; i <k; i++) {
            leftsum+=arr[i];
        }
        
        int l = k;
        int r = arr.length;
        int lans = 0;
        int rans = 0;
        int sum = 0;
        int maxSum = leftsum;
        for (int i = 0; i <k; i++) {
            l--;
            r--;
            leftsum -=arr[l];
            rightsum +=arr[r];
            
            sum = leftsum + rightsum;
             if (sum>maxSum) {
                maxSum = sum;
                lans = l;
                rans = r;
             }
          
        }
        System.out.println("");
        System.out.println("       maxLEN     " + maxSum);
        System.out.println("       Right     " + lans);
        System.out.println("       Left     " + (rans));
    }
}
