import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int j =0;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int levelSize = q.size();
           
            for(int i =0;i<levelSize;i++){
                TreeNode t = q.poll();
                 if(t.left!=null) q.offer(t.left);
                 if(t.right!=null) q.offer(t.right);
                 if(j%2==0) temp.add(t.val);
                 else temp.add(0,t.val);
            }
            ans.add(temp);
            j++;
        }
        return ans;
    }
}
}
