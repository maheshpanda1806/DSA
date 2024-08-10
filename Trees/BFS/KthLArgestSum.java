public class KthLArgestSum {
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
        public long kthLargestLevelSum(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }
    
            Queue<TreeNode> q = new LinkedList<>();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            q.offer(root);
    
            while (!q.isEmpty()) {
                int levelSize = q.size();
                long sum = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode temp = q.poll();
                    sum += (long) temp.val;
                    if (temp.left != null) q.offer(temp.left);
                    if (temp.right != null) q.offer(temp.right);
                }
                pq.offer(sum);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
    
            // Check if there are fewer than k levels
            if (pq.size() < k) {
                return -1;
            }
    
            return pq.poll();
        }
    }
}

