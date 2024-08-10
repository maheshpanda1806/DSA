import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PathSum123 {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if(root==null) return false;
      if(targetSum-root.val==0 && root.left==null && root.right==null) return true;//root.left===null and 
      //root.right==null issloye checkarna hai kyuki 
      //leaf node tak sum find karna hai(aisa question mein bola hai) aisa nhi kiye 
      //toh jidhar bhi zero hoga uske neeche check nhi karega
      boolean left = hasPathSum(root.left,targetSum-root.val);
      if(left) return true;
      boolean right = hasPathSum(root.right,targetSum-root.val);
      if(right) return true;

      return false;
    }
}


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        helper(root,new ArrayList<>(),ans,targetSum);
        return ans;
    }
    public void helper(TreeNode root,List<Integer> ds,List<List<Integer>> ans, int targetSum){
        if(root==null) return;
        ds.add(root.val);
        if(root.left==null && root.right==null && targetSum-root.val==0){
           ans.add(new ArrayList<>(ds));
           ds.remove(ds.size()-1);
           return;
        }
        
        // ds.add(root.val);
        helper(root.left,ds,ans,targetSum-root.val);
        helper(root.right,ds,ans,targetSum-root.val);
        
        ds.remove(ds.size()-1);
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        count = 0;
        
        // Traverse each node and use it as the starting point for path search
        traverse(root, (long)targetSum);
        return (int)count;
    }
    
    // Traverse the tree
    private void traverse(TreeNode node, long targetSum) {
        if (node == null) return;
        
        // Count paths starting from the current node
        countPathsFromNode(node, targetSum);
        
        // Traverse left and right subtree
        traverse(node.left, targetSum);
        traverse(node.right, targetSum);
    }
    
    private void countPathsFromNode(TreeNode node, long targetSum) {
        if (node == null) return;
        
        if ((long)node.val == targetSum) {
            count++;
        }
        
        // Continue to check paths in left and right subtrees with updated targetSum
        countPathsFromNode(node.left, targetSum - (long)node.val);
        countPathsFromNode(node.right, targetSum - (long)node.val);
    }
}
