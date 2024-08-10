public class MiDepthOfTree {
    
}
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
    public int min;
    public int minDepth(TreeNode root) {
         if(root==null) return 0;
        min=Integer.MAX_VALUE;
        helper(root,1);
        return min;
    }
    public void helper(TreeNode root,int depth){
        if(root==null) return;
        if(root.left==null && root.right==null){
           min = Math.min(min,depth);
           return;
        }
        helper(root.left,depth+1);
        helper(root.right,depth+1);
    }
}