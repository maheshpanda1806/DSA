import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class AllTraversalInOneGo {
  

    public static void inOneGo(TreeNode root){
        Stack<Map.Entry<TreeNode,Integer>> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        st.push(Map.entry(root,1));
        while (!st.isEmpty()) {
            Map.Entry<TreeNode,Integer> temp = st.pop();
            if(temp.getValue()==1){
                pre.add(temp.getKey().val);
                temp.setValue(temp.getValue()+1);
                st.push(temp);
                if(temp.getKey().left!=null) st.push(Map.entry(temp.getKey().left,1));
            }
            if(temp.getValue()==2){
                in.add(temp.getKey().val);
                temp.setValue(temp.getValue()+1);
                st.push(temp);
                if(temp.getKey().right!=null) st.push(Map.entry(temp.getKey().right,1));
            }
            if(temp.getValue()==3){
                in.add(temp.getKey().val);
            }
        }
        System.out.println("The PreOrderTraversal of This Tree IS: " + pre);
        System.out.println("The InOrderTraversal of This Tree IS: " + in);
        System.out.println("The PostOrderTraversal of This Tree IS: " + post);

    }
    public static void main(String[] args) {
        // Creating the nodes
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode root = new TreeNode(1, node2, node5);
        
        inOneGo(root);
        // The tree is now created with root as the root node
    }
}
