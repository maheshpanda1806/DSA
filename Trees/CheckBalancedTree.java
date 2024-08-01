public class CheckBalancedTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);
            if(Math.abs(lh-rh)>1) return false;
            boolean left = isBalanced(root.left);
            if(!left) return false;
            boolean right = isBalanced(root.right);
            if(!right) return false;
    
            return true;
    
            
        }
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
    
}
