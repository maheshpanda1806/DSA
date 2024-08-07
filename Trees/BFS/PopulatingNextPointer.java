import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointer {
    /*
// Definition for a Node.
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
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            
            for(int i =0;i<levelSize;i++){
              Node temp =  q.poll();
              if(temp.left!=null) q.offer(temp.left);
              if(temp.right!=null) q.offer(temp.right);
            if(i==levelSize-1) temp.next=null;
                else temp.next = q.peek();
            }
        }
        return root;
    }
}
}
