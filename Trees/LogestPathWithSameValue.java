import javax.swing.tree.TreeNode;

public class LogestPathWithSameValue {
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
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        if(root==null) return 0;
        traverse(root);
        return max-1;//my code id calculating the no of nodes we want no of edges 
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        helper(root,root.val);
        traverse(root.left);
        traverse(root.right);
    }
    public int helper(TreeNode root,int val){
        if(root==null) return 0;
        
        if(root.val!=val) return 0;
        int left = helper(root.left,val);
        int right = helper(root.right,val);

        max= Math.max(max,Math.max(left+right+1,Math.max(left+1,right+1)));

        return Math.max(left+1,right+1);

    }
}
}
