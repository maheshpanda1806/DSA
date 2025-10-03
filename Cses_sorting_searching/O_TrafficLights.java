
import java.util.*;

public class O_TrafficLights {
    //static final long MOD = 1000000007;
        public static void soln(int[] arr,int n,int x){
            TreeSet<Integer[]> set = new TreeSet<>((arr1, arr2) -> arr1[0] - arr2[0]);
            TreeSet<Integer[]> dist = new TreeSet<>((arr1, arr2) -> {
                int diff1 = arr2[1] - arr2[0];
                int diff2 = arr1[1] - arr1[0];
                if (diff1 != diff2) {
                    return diff1 - diff2;
                }
                return arr1[0] - arr2[0];
            });
            int k = 0;
            int[] ans = new int[n];
             set.add(new Integer[] {0,x});
             dist.add(new Integer[] {0,x});
            for (int i = 0; i < arr.length; i++) {
                int pos =  arr[i];
                Integer[] key = set.lower(new Integer[] {pos,Integer.MAX_VALUE});
                set.remove(key);
                dist.remove(key);
                set.add(new Integer[] {key[0],pos});
                set.add(new Integer[] {pos,key[1]});
                
                
                dist.add(new Integer[] {key[0],pos});
                dist.add(new Integer[] {pos,key[1]});

                Integer[] temp = dist.first();
                ans[k++] = temp[1]-temp[0];

            }
            for (int j : ans) {
                System.out.print(j+" ");
            }
        }
       
       
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n =  sc.nextInt();
      
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
           arr[i]=sc.nextInt();
        }
         soln(arr,n,x);
        //System.out.println(ans);    
        sc.close();
    } 
}
