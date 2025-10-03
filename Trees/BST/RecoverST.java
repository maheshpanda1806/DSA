package ST;


public class RecoverST {
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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    //inorder dfs(mostly for bst) validate bst mein bhi yeh karne ka
    public void recoverTree(TreeNode root) {
        first=null;
        second=null;
        prev = null;
        helper(root);
        swap(first,second);
    }
    public void swap(TreeNode q,TreeNode p){
        int temp = q.val;
        q.val = p.val;
        p.val=temp;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        
        helper(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
              first = prev;
            } second = root;
        }
        prev = root;
        helper(root.right);


    }
}
}
