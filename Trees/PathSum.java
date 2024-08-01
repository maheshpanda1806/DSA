public class PathSum {
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
}
