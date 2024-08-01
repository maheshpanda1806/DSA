import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccesor {
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
}
