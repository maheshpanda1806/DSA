public class VerticalOrderTraverSal {
    
}/**
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
    public PriorityQueue<Map.Entry<TreeNode, int[]>> queue;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
       queue = new PriorityQueue<>((o1, o2) -> {
            // Compare by arr[1]
            if (o1.getValue()[1] != o2.getValue()[1]) {
                return Integer.compare(o1.getValue()[1], o2.getValue()[1]);
            }
            // If arr[1] is the same, compare by arr[0]
            if (o1.getValue()[0] != o2.getValue()[0]) {
                return Integer.compare(o1.getValue()[0], o2.getValue()[0]);
            }
            // If both arr[1] and arr[0] are the same, compare by TreeNode.val
            return Integer.compare(o1.getKey().val, o2.getKey().val);
        });
        traverse(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
           Map.Entry<TreeNode, int[]> entry = queue.poll();
           int col = entry.getValue()[1];
           if (col != prevCol) {
               ans.add(new ArrayList<>());
               prevCol = col;
           }
           ans.get(ans.size() - 1).add(entry.getKey().val);
        }
        return ans;
    }
    public void traverse(TreeNode root, int row, int col){
        if(root==null) return;

        queue.offer(Map.entry(root,new int[] {row,col}));

        traverse(root.left, row+1, col-1);
        traverse(root.right, row+1, col+1);

    }
}
