import java.util.LinkedList;
import java.util.Queue;


public class Perimeter {
        int count;
        public int islandPerimeter(int[][] grid) {
            count = 0;
            int m = grid.length;
            int n =  grid[0].length;
            boolean[][] vis = new boolean[m][n];
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]!= 0 && !vis[i][j]) bfs(grid,i,j,m,n,vis);
                }
            }
            return count;
        }
        public void bfs(int[][] grid, int x, int y,int m,int n,boolean[][] vis){
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {x,y});
            vis[x][y] = true;
            while(!q.isEmpty()){
                int[] temp = q.poll();
                int i = temp[0];
                int j = temp[1];
                if(check1(grid,i+1,j,m,n)) count++;
                if(check(grid,i+1,j,m,n,vis)){
                    vis[i+1][j] = true;
                    q.offer(new int[] {i+1,j});
                }
                if(check1(grid,i-1,j,m,n)) count++;
                if(check(grid,i-1,j,m,n,vis)){
                    vis[i-1][j] = true;
                    q.offer(new int[] {i-1,j});
                }
                if(check1(grid,i,j-1,m,n)) count++;
                if(check(grid,i,j-1,m,n,vis)){
                    vis[i][j-1] = true;
                    q.offer(new int[] {i,j-1});
                }
                if(check1(grid,i,j+1,m,n)) count++;
                if(check(grid,i,j+1,m,n,vis)){
                    vis[i][j+1] = true;
                    q.offer(new int[] {i,j+1});
                }
            }
            return;
        }
        public boolean check1(int[][] grid, int i, int j,int m,int n){
            if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) return true;
            else return false;
        }
       public boolean check(int[][] grid, int i, int j,int m,int n,boolean[][] vis){
            if(i<0 || j<0 || i>=m || j>=n || vis[i][j] || grid[i][j]==0) return false;
            else return true;
        }
    

    public void dfs(int[][] grid, int x, int y,int m,int n,boolean[][] vis){
        
        vis[x][y] = true;

        if(check1(grid,x+1,y,m,n)) count++;
        if(check1(grid,x-1,y,m,n)) count++;
        if(check1(grid,x,y-1,m,n)) count++;
        if(check1(grid,x,y+1,m,n)) count++;

        if(check(grid,x+1,y,m,n,vis)) dfs(grid,x+1,y,m,n,vis);
        if(check(grid,x-1,y,m,n,vis)) dfs(grid,x-1,y,m,n,vis);
        if(check(grid,x,y-1,m,n,vis)) dfs(grid,x,y-1,m,n,vis);
        if(check(grid,x,y+1,m,n,vis)) dfs(grid,x,y+1,m,n,vis);

    }
}
