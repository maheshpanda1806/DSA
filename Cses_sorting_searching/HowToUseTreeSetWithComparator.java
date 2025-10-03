import java.util.*;
public class HowToUseTreeSetWithComparator {
    //static final int MOD = 1000000007;
    public static void soln(int[]arr, int n){
        TreeSet<Integer[]> set = new TreeSet<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
      int[] ans = new int[n];
      for(int i =0;i<n;i++){
        Integer[] nums = new Integer[] {arr[i],i};
        Integer[] key = set.lower(nums);
        
        if(key==null){
            ans[i] = -1;
        }else{
            ans[i] = (int)key[1];
        }
        set.add(nums);      
     }

     for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i]+1+" ");
     }
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
           arr[i]=sc.nextInt();
        }    
        
        soln(arr,n);       
        sc.close();
    } 
}


