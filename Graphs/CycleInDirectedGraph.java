
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Set<Integer> st = new HashSet<>();
        for(int i =0;i<V;i++){
            if(!visited[i]){
                boolean g = dfs(V,adj,i,visited,st);
                if(g) return true;
            }
        }
        return false;
    }
    //DFS
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited,Set<Integer> path){
        //base cases and pruning
        if(path.contains(node)) return true;
        if(visited[node]) return false;
        
        visited[node] = true;
         path.add(node);
        boolean flag = false;
        for(int i : adj.get(node)){
           flag = flag || dfs(V,adj,i,visited,path);
        }
         path.remove(node);
        return flag;
    }
}