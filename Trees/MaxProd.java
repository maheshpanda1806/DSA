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
    //METHOD 2
    int len = 0; // global variable
public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    len = 0;
    getLen(root, root.val);
    return len;
}

private int getLen(TreeNode node, int val) {
    if (node == null) return 0;
    int left = getLen(node.left, node.val);
    int right = getLen(node.right, node.val);
    len = Math.max(len, left + right);
    if (val == node.val)  return Math.max(left, right) + 1;
    return 0;
}
}
