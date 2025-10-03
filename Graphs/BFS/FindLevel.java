import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindLevel {
     int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X){    
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        
        int level = -1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i =0;i<size;i++){
                int temp = q.poll();
                if(temp==X) return level;
                for(int j : adj.get(temp)){
                    if(visited[j]==false){
                        visited[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        
        return -1;
    }
}
