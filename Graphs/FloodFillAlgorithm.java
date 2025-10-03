import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
    class Solution {
    public int[][] floodFill(int[][] matrix, int sr, int sc, int color) {
        int startColor = matrix[sr][sc];
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr,sc});
        visited[sr][sc]=true;
        while(!q.isEmpty()){
          int[] curr = q.poll();
           if(check(curr[0],curr[1]+1,matrix,m,n,startColor,visited)){
             q.offer(new int[] {curr[0],curr[1]+1});
             visited[curr[0]][curr[1]+1]=true;
           }
           if(check(curr[0]+1,curr[1],matrix,m,n,startColor,visited))
           { q.offer(new int[] {curr[0]+1,curr[1]});
             visited[curr[0]+1][curr[1]]=true;
           }
           if(check(curr[0]-1,curr[1],matrix,m,n,startColor,visited))
           { q.offer(new int[] {curr[0]-1,curr[1]});
           visited[curr[0]-1][curr[1]]=true;
           }
           if(check(curr[0],curr[1]-1,matrix,m,n,startColor,visited)) {
            q.offer(new int[] {curr[0],curr[1]-1});
            visited[curr[0]][curr[1]-1]=true;
            }
        }

        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(visited[i][j]) matrix[i][j]=color;
            }
        }
        return matrix;
        }
        public boolean check(int i,int j,int[][] matrix,int m,int n,int startColor,boolean[][] visited){
            if(i<0||i>=m||j<0||j>=n||matrix[i][j]!=startColor|| visited[i][j]) return false;
            return true;
        }
}
}
