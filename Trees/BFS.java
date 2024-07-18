import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BFS {

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

    public TreeNode levelOrderSuccessorNode(TreeNode root, int k){
        if (root ==null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
             if (current.left != null) {
                    q.offer(current.left);
                }
            if (current.right != null) {
                    q.offer(current.right);
                }
            if (current.val==k) {
                return q.poll();
            }
        }
        return null;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
      if (root ==null) {
        return ans;
      }
      Deque<TreeNode> q = new ArrayDeque<>();
     q.offer(root);
     boolean isRev = false;
     while (!q.isEmpty()) {
     int levelSize = q.size();
     List<Integer> currentLevel = new ArrayList<>(levelSize);

     for (int i = 0; i <levelSize; i++) {
        if (isRev) {
             TreeNode current = q.pollLast();
            currentLevel.add(current.val);
              if (current.left != null) {
                    q.offerFirst(current.left);
                }
            if (current.right != null) {
                    q.offerFirst(current.right);
                }

        
        } else {
            TreeNode current = q.pollFirst();
            currentLevel.add(current.val);
              if (current.left != null) {
                    q.offerLast(current.left);
                }
            if (current.right != null) {
                    q.offerLast(current.right);
                }

        }
     }
     ans.add(currentLevel);

        isRev = !isRev;
     }
     



      return ans;
    
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
               TreeNode current = q.poll();
               if (i==levelSize-1) {
                    ans.add(current.val);
                }
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
                
            }
        }
        return ans;
    }

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