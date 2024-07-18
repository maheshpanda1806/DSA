import java.util.*;
public class NumerbsOfWayOfDice {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        numbersOfWayTogetTarget(1, 8, new ArrayList<>(), ans);
       System.out.println(ans);
    }

    //combination Sum.......
//     Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of 
//candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is 
//less than 150 combinations for the given input.

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []
    public static void numbersOfWayTogetTarget(int i,int target,List<Integer> ds,List<List<Integer>> ans){
      if(i>target){
        if (target==0) {
            ans.add(new ArrayList<>(ds));
        }
        return;
      }
      if (i<=target) {
        ds.add(i);
        numbersOfWayTogetTarget(i, target-i, ds, ans);
        ds.remove(ds.size()-1);
      }
      numbersOfWayTogetTarget(i+1, target, ds, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        soln(candidates,0,target,new ArrayList<>(),ans);
        return ans;
        }
        public  void soln(int []arr ,int idx,int target,List<Integer> ds,List<List<Integer>> ans){
        //base case
            if(idx > arr.length-1){
                if(target==0) ans.add(new ArrayList<>(ds));
                return;
            }
            if(arr[idx]<=target){
                ds.add(arr[idx]);
                soln(arr,idx,target-arr[idx],ds,ans);
                ds.remove(ds.size()-1);  
            }
    
                soln(arr,idx+1,target,ds,ans);    
        }



/* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]*/
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    soln(candidates, 0, target, new ArrayList<>(), ans);
    return ans;
}

public void soln2(int[] arr, int idx, int target, List<Integer> ds, List<List<Integer>> ans) {
    // Base case
    if (target == 0) {
        ans.add(new ArrayList<>(ds));
        return;
    }
    
    for (int i = idx; i < arr.length; i++) {
        if (i > idx && arr[i] == arr[i - 1]) // Skip duplicates
            continue;
        
        if (arr[i] > target)
            break;
        
        ds.add(arr[i]);
        soln(arr, i + 1, target - arr[i], ds, ans);
        ds.remove(ds.size() - 1);
     }
   }
}

