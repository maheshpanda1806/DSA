import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
//dfs
class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans =  new ArrayList<>();
        for(int i = 0;i<adj.size();i++){
            dfs(adj,i,stack,visited);
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int node,Stack<Integer> stack,boolean[] visited){
        //pruning
        if(visited[node]) return;
        
        visited[node]= true;
        
        for(int i : adj.get(node)){
            dfs(adj,i,stack,visited);
        }
        stack.push(node);
    }
}

//bfs
class Solution2 {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
      
        boolean[] visited = new boolean[adj.size()];
        int[] indegree = new int[adj.size()];
        Arrays.fill(indegree,0);
        for(int i = 0;i<adj.size();i++){
            for(int j : adj.get(i)) indegree[j]++;
        }
        
         Queue<Integer> q = new LinkedList<>();
         for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){ q.offer(i);
            visited[i]=true;
            }
        }
        ArrayList<Integer> ans =  new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    indegree[i]--;
                    if(indegree[i]==0){ 
                          q.offer(i);
                          visited[i]=true;
                    }
                }
            }
        }
        return ans;
    }
  }
}