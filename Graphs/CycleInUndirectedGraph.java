import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        
    }
    //using bfs
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {    //To Handle Disconnected Components
            if (!visited[i]) {
                if (checkCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCycle(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    
}



  

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
         
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {    //To Handle Disconnected Components
            if (!visited[i]) {
                if (dfs(V, adj,i,-1,visited)) {
                    return true;
                }
            }
        }
        return false;
    

    }
    
    public boolean dfs(int V,ArrayList<ArrayList<Integer>> adj, int node,int parent,boolean[] visited){
        
        if(visited[node]) return true;
        
        visited[node] = true;
        
        boolean g = false;
        for(int i : adj.get(node)){
            if(parent!=i){
               boolean f =  dfs(V,adj,i,node,visited);
               if(f) return true;
               
            } 
        }
       return g;
    }

}
}
