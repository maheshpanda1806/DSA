import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    q.offer(new int[] {i,j});
                    visited[i][j]=true;
                }
            }
            }
            int dist=1;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                   int [] curr = q.poll();
                   int x = curr[0];
                   int y = curr[1];

                   //add neigbors
                    if(check(x, y+1, matrix, m, n, visited)){
                    q.offer(new int[] {x, y+1});
                    visited[x][y+1] = true;
                    matrix[x][y+1] = dist;
                    
                }
                if(check(x+1, y, matrix, m, n, visited)){
                    q.offer(new int[] {x+1, y});
                    visited[x+1][y] = true;
                    matrix[x+1][y] = dist;
                   // freshCount--;
                }
                if(check(x-1, y, matrix, m, n, visited)){
                    q.offer(new int[] {x-1, y});
                    visited[x-1][y] = true;
                    matrix[x-1][y] = dist;
                    //freshCount--;
                }
                if(check(x, y-1, matrix, m, n, visited)) {
                    q.offer(new int[] {x, y-1});
                    visited[x][y-1] = true;
                    matrix[x][y-1] = dist;
                    //freshCount--;
                }
                }
                dist++;
            }

            return matrix;
        
    }
    public boolean check(int i, int j, int[][] matrix, int m, int n, boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n  || matrix[i][j] == 0 || visited[i][j]) return false;
        return true;
    }
}
}
