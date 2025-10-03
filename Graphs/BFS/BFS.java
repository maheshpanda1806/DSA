import java.util.*;
public class BFS{
    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> ans =  new ArrayList<>();
            boolean[] visited = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            visited[0]=true;
            while(!q.isEmpty()){
             int temp = q.poll();
             for(int i : adj.get(temp)){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
             }
             ans.add(temp);
            }
            return ans;
        }
        
    }
}