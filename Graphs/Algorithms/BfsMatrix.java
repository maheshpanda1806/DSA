import java.util.LinkedList;
import java.util.Queue;

public class BfsMatrix {
    public boolean check(char[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]=='0') return false;
        return true;
    }
     public void bfs(char[][] grid,boolean[][] vis,int x,int y){
       Queue<int[]> q = new LinkedList<>();
       q.offer(new int[] {x,y});
       vis[x][y]=true;

       while(!q.isEmpty()){
        int[] temp = q.poll();
        int i = temp[0];
        int j = temp[1];
        if(check(grid,vis,i+1,j)){
            vis[i+1][j]=true;
            q.offer(new int[] {i+1,j});
        }
        if(check(grid,vis,i-1,j)){
            vis[i-1][j]=true;
            q.offer(new int[] {i-1,j});
        }
        if(check(grid,vis,i,j+1)){
            vis[i][j+1]=true;
            q.offer(new int[] {i,j+1});
        }
        if(check(grid,vis,i,j-1)){
            vis[i][j-1]=true;
            q.offer(new int[] {i,j-1});
        }
       }
    }
}
