public class MooreVotingAlgorithm {
    public static void main(String[] args) {
       
        int [] arr={3,2,3};
        System.out.println(majorityElement(arr));
    }
    public static int majorityElement(int[] a) {
        int ansIdx=0;
        int count=1;
        for (int i = 1; i < a.length; i++) {
            if (a[i]==a[ansIdx]) {
                count++;
            } else {
                count--;
            }
            if(count==0){
                ansIdx=i;
                count =1;
            }
        }
        return a[ansIdx];
        // int count2=0;
        // for (int i = 0; i < a.length; i++) {
        //     if (a[ansIdx]==a[i]) {
        //         count2++;
        //     }
        // }
        // if (a.length/2<count2) {
        //     return a[ansIdx];
        // }
        //    return -1 ;
         }
}
