import java.util.*;

public class IterativeTraversals {
    //preorder using 1 stack
    public static List<Integer> preorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ans.add(temp.val);
            if(temp.left!=null) st.push(temp.right);
            if(temp.right!=null) st.push(temp.right);
        }
        return ans;
    }
    //inorder using 1 stack
    public static List<Integer> inorder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            
        if(node!=null){//move left when not null
          st.push(node);
          node = node.left;
        }else{//if null print the topmost and move right
           if(st.isEmpty()) break;
           TreeNode temp = st.pop();
           ans.add(temp.val);
           node = temp.right;//moves right
        }
        
        }
        return ans;
    }

    


}
