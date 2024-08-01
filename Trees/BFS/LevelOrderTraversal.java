import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
     public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();

                currentLevel.add(current.val);
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            ans.add(currentLevel);
        }
        return ans;
    }

    public List<Double> avg(TreeNode root){
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
          int levelSize = q.size();
          double sum =0;
          for (int i = 0; i < levelSize; i++) {
              TreeNode current = q.poll();
              sum+=current.val;
              if (current.left != null) {
                      q.offer(current.left);
                  }
                  if (current.right != null) {
                      q.offer(current.right);
                  }
          }
          ans.add(sum/levelSize);
        }
  
        return ans;
      }
     ///LEETCODE 107
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
       if (root == null) {
           return ans;
       }
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       while (!q.isEmpty()) {
           int levelSize = q.size();
           List<Integer> currentLevel = new ArrayList<>(levelSize);

           for (int i = 0; i < levelSize; i++) {
               TreeNode current = q.poll();

               currentLevel.add(current.val);
               if (current.left != null) {
                   q.offer(current.left);
               }
               if (current.right != null) {
                   q.offer(current.right);
               }
           }
           ans.add(0,currentLevel);
       }
       return ans;
   }
}
}
