class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        int x = 0;
    for(int k =0;km;k++){
            if(visited[k]==-1){
                
        q.offer(k);
        visited[k]=x;

        while(!q.isEmpty()){
            int temp=q.poll();
            x = 1-visited[temp];switch color
            for(int i  graph[temp]){
                if(visited[i]==-1){visit and add to queue only if unvisited
                     q.offer(i);
                     visited[i]=x;
                }else{
                    System.out.println(Arrays.toString(visited));
                    if(visited[i]==1-x) return false;
                }
            }
        }
            }
        }
        System.out.println(Arrays.toString(visited));
        return true;
    }
}

//dfs
class Solution2 {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited,-1);
        boolean ans = true;
        for(int i=0;i<graph.length;i++){
                if(visited[i]==-1) ans = ans && dfs(i,0,graph,visited); 
        }
        return ans;
    }
    public boolean dfs(int node,int color,int[][] graph,int[] visited){
        //
        if(visited[node]!=-1){
           if(visited[node]==1-color) return false;
           else return true;
        }
        
        visited[node]=color;
        
        boolean ans = true;
        for(int i : graph[node]){
            ans= ans && dfs(i,1-color,graph,visited);
        }
     return ans;

    }
}