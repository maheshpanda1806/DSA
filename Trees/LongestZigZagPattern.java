class Solution {
    int max = 0;
    
    public int longestZigZag(TreeNode root) {
        // Start DFS from the root in both directions
        dfs(root, true, 0);  
        dfs(root, false, 0); 
        return max;
    }
    
    // isLeft - boolean indicating whether we came from the left child or right child
    // length - length of the zigzag path up to the current node
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }
        
        max = Math.max(max, length);
        
        // If we came from the left, continue zigzag to the right
        if (isLeft) {
            dfs(node.right, false, length + 1);  // Move to the right child
            dfs(node.left, true, 1);             // Start new zigzag from left child
        } else {
            // If we came from the right, continue zigzag to the left
            dfs(node.left, true, length + 1);   // Move to the left child
            dfs(node.right, false, 1);          // Start new zigzag from right child
        }
    }
}
