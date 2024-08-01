import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class connectInLevel {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      while (!q.isEmpty()) {
        int levelsize = q.size();
        for (int i = 0; i <levelsize ; i++) {
            Node current =q.poll();

            if (current.left != null) {
                q.offer(current.left);
            }
        if (current.right != null) {
                q.offer(current.right);
            }

            if (i!= levelsize-1) {
                current.next = q.peek();
            }else{
                current.next= null;
            }
        }
      }     
        return root;
    }

    public Node connectWitoutQueue(Node root) {
    if(root==null) return null;
    
     return root;
    }
}
