public class MaxProd {
    class Solution {
        public int maxProduct(TreeNode root) {
            long sum = sumOfTree(root);
            maxSum(root, sum);
            return (int)(max % (int)(Math.pow(10, 9) + 7));
        }
        
        long max = 0;
        
        public long maxSum(TreeNode root, long sum){
            if(root == null) return 0;
            
            long left = maxSum(root.left, sum);
            long right = maxSum(root.right, sum);
            
            long curr = left + right + root.val;
            max = Math.max(max, curr * (sum - curr));
            return curr;
        }
        
        public long sumOfTree(TreeNode root){
            if(root == null) return 0;
            
            long left = sumOfTree(root.left);
            long right = sumOfTree(root.right);
            
            return left + right + root.val;
        }
    }
   
}
