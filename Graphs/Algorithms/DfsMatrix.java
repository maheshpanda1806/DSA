public class DfsMatrix {
    public boolean check(char[][] grid,boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j]=='0') return false;
        return true;
    }
    public void dfs(char[][] grid,boolean[][] vis,int i,int j){
       
        vis[i][j]=true;
 
        if(check(grid,vis,i+1,j)) dfs(grid,vis,i+1,j);
        if(check(grid,vis,i-1,j)) dfs(grid,vis,i-1,j);
        if(check(grid,vis,i,j+1)) dfs(grid,vis,i,j+1);
        if(check(grid,vis,i,j-1)) dfs(grid,vis,i,j-1);
     }
}
