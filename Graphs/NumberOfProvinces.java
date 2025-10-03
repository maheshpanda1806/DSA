import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces{
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[isConnected.length];
        
        for(int i =0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }

    public void dfs(int node,int[][] matrix, boolean[] visited){
       visited[node]=true;
       for(int i =0;i<matrix[node].length;i++){
         if(matrix[node][i]==1){
            if(!visited[i]) dfs(i,matrix,visited);// for bfs call bfs method
         }
       }
    } 

     public void bfs(int[][] adjMat,boolean[] vis,int node){
       Queue<Integer> q = new LinkedList<>();
       q.offer(node);
       vis[node]=true;

       while(!q.isEmpty()){
        int temp = q.poll();
        for(int i=0;i<adjMat.length;i++){
            if(adjMat[temp][i]==1 && !vis[i]){
                vis[i]=true;
                q.offer(i);
            }
        }
       }
    }
}