import java.util.*;
 
public class E_RestaurantCustomer{
    static final int MOD = 1000000007;
   
    public static int soln(int[][] arr,int n ,int max){
        int[] numberLine = new int[max+2];
 
        for (int[] i : arr) {
            int start = i[0];
            int end =  i[1];
 
            numberLine[start]++;
            numberLine[end+1]--;
        }
        int maxi = -(int)1e9;
        for (int i = 1; i <= max; i++) {
            numberLine[i] = numberLine[i] + numberLine[i-1];
            if(maxi<numberLine[i]) maxi = numberLine[i];
        }
        return maxi;
    }
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = -1;
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            max = Math.max(a,max);
            max = Math.max(b,max);
            arr[i][0] = a;
            arr[i][1] = b;
        }    
        int ans = soln(arr,n,max);
        System.out.println(ans);
        
        sc.close();
    } 
}
