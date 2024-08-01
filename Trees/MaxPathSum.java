public class MaxPathSum {
    
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
    public static int maxi;

    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        soln(root);
        return maxi;
    }

    public int soln(TreeNode root) {
        if (root == null) return 0;

        int left = soln(root.left);
        int right = soln(root.right);

        int includingLeft = root.val + left;
        int includingRight = root.val + right;
        int all = root.val + right + left;
        int alone = root.val;

        int sum = Math.max(all, Math.max(includingLeft, Math.max(includingRight, alone)));
        maxi = Math.max(maxi, sum);
        //[5,4,8,11,null,13,4,7,2,null,null,null,1] yeh wala test dekh samjh jaayega ya notes dekh ke hum upar sum kyu nhi bhej rahe hai

        return Math.max(alone, Math.max(includingLeft, includingRight));
    }
}
