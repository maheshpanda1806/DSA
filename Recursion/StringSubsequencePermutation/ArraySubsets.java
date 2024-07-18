import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySubsets {
    public static void main(String[] args) {
        
    }
    /*Subet 1
     * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
     
     */
     public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        soln1(nums,0,ds,ans);
        return ans;
    }
    public void soln1(int[] nums,int idx,List<Integer> ds, List<List<Integer>> ans){
        if(idx>=nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        //not pick
        soln1(nums,idx+1,ds,ans);
        
        //pick
        ds.add(nums[idx]);
        soln1(nums,idx+1,ds,ans);
         ds.remove(ds.size()-1); 
        
    }

    /*
     * Subet 2
     * Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
     */
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ansSet = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        soln(nums, 0, ds, ansSet);
        
        // Convert HashSet to List
        List<List<Integer>> ansList = new ArrayList<>(ansSet);
        return ansList;
    }

    public void soln(int[] nums, int idx, List<Integer> ds, HashSet<List<Integer>> ans) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(ds)); // Create a new list and add it to ans
            return;
        }
        // not pick
        soln(nums, idx + 1, ds, ans);

        // pick
        ds.add(nums[idx]);
        soln(nums, idx + 1, ds, ans);
        ds.remove(ds.size() - 1);

    }

    //Subset Sum-1
    public List<Integer> subsetSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> ansSet = new HashSet<>();
        
        soln2(nums, 0, ansSet,0);
        
        // Convert HashSet to List
        List<Integer> ansList = new ArrayList<>(ansSet);
        return ansList;
    }

    public void soln2(int[] nums, int idx, HashSet<Integer> ds,int sum) {
        if (idx >= nums.length) {
            ds.add(sum); // Create a new list and add it to ans
            return;
        }

        // not pick
        soln2(nums, idx + 1, ds, sum);

        // pick
        soln2(nums, idx + 1, ds, sum+nums[idx]);
    }

}


