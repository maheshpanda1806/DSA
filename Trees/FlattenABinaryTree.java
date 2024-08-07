public class FlattenABinaryTree {
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
    public void flatten(TreeNode root) {
      if(root==null) return;
      TreeNode curr = root;
      TreeNode temp = root.right;
      root.right = root.left;
      root.left = null;

      TreeNode temp2 = root;
      while(temp2.right!=null){
        temp2= temp2.right;
      }
      temp2.right = temp;

      flatten(root.right);

    }
    
}
}
