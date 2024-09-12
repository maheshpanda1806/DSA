import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class TravelToParent {
    //Infection
    class Solution {
        TreeNode startNode = null;
    
        public int amountOfTime(TreeNode root, int start) {
            HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
            findParentAndStart(root, null, start, parentMap);
    
            Queue<TreeNode> queue = new LinkedList<>();
            HashSet<TreeNode> visited = new HashSet<>();
    
            queue.offer(startNode);
            visited.add(startNode);
    
            int time = 0;
    
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean spread = false;
                for (int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();
                    if (current.left != null && !visited.contains(current.left)) {
                        queue.offer(current.left);
                        visited.add(current.left);
                        spread = true;
                    }
                    if (current.right != null && !visited.contains(current.right)) {
                        queue.offer(current.right);
                        visited.add(current.right);
                        spread = true;
                    }
                    if (parentMap.get(current) != null && !visited.contains(parentMap.get(current))) {
                        queue.offer(parentMap.get(current));
                        visited.add(parentMap.get(current));
                        spread = true;
                    }
                }
                if (spread) {
                    time++;
                }
            }
    
            return time;
        }
    
        private void findParentAndStart(TreeNode node, TreeNode parent, int start, HashMap<TreeNode, TreeNode> parentMap) {
            if (node == null) return;
    
            parentMap.put(node, parent);
    
            if (node.val == start) {
                startNode = node;
            }
    
            findParentAndStart(node.left, node, start, parentMap);
            findParentAndStart(node.right, node, start, parentMap);
        }
    }
    
    //All Nodes At Distance K
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,TreeNode> mpp = new HashMap<>();
        mappingParent(mpp,null,root);
        dfs(ans,mpp,visited,k,0,target);
        return ans;
    }
    public void dfs(List<Integer> ans,HashMap<TreeNode,TreeNode> mpp,HashSet<TreeNode> visited,int k,int depth,TreeNode curr){
        if(curr==null) return; 
        if(depth>k) return;
        if(visited.contains(curr)) return;
        if(!visited.contains(curr) && depth==k) ans.add(curr.val);

        visited.add(curr);

        dfs(ans,mpp,visited,k,depth+1,curr.left);
        dfs(ans,mpp,visited,k,depth+1,curr.right);
        dfs(ans,mpp,visited,k,depth+1,mpp.get(curr));//parent
    }
    public void mappingParent(HashMap<TreeNode,TreeNode> mpp,TreeNode parent,TreeNode curr){
        if(curr==null) return;

        mpp.put(curr,parent);
        mappingParent(mpp,curr,curr.right);
        mappingParent(mpp,curr,curr.left);
    }
}
