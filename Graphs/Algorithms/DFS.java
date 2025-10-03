import java.util.*;
public class DFS {
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0,adj,vis,ans);
        return ans;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> ans){
      
      ans.add(node);
      vis[node] = true;
      
      for(int i : adj.get(node)){
          if(!vis[i]) dfs(i,adj,vis,ans);
      }
    }
}

