import java.util.LinkedList;
import java.util.List;
public class SurroundedRegion {
    

class Solution {
    public void solve(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;  // Edge case: empty matrix
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> list = new LinkedList<>();
        
        // First pass: Identify 'O's not connected to the border
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 'O' && !visited[i][j]){
                    // Perform DFS to check if the region is surrounded
                    if(dfs(i, j, m, n, matrix, visited)){
                        list.add(new int[] {i, j});
                    }
                }
            }
        }
        
        // Second pass: Fill surrounded regions
        for(int[] point : list){
            int x = point[0];
            int y = point[1];
            fill(x, y, m, n, matrix);  // Fill the surrounded region
        }
    }

    // DFS to check if a region is surrounded (returns false if it touches the boundary)
    public boolean dfs(int i, int j, int m, int n, char[][] matrix, boolean[][] visited){
        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;  // Reached the boundary, not surrounded
        }
        if(matrix[i][j] == 'X' || visited[i][j]) return true;  // Safe region or already visited

        visited[i][j] = true;

        // Check all four directions and return false if any direction leads to the boundary
        boolean up = dfs(i + 1, j, m, n, matrix, visited);
        boolean down = dfs(i - 1, j, m, n, matrix, visited);
        boolean right = dfs(i, j + 1, m, n, matrix, visited);
        boolean left = dfs(i, j - 1, m, n, matrix, visited);

        return up && down && right && left;  // Return true if all directions are surrounded
    }

    // Fill the surrounded region with 'X'
    public void fill(int i, int j, int m, int n, char[][] matrix){
        if(i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == 'X') {
            return;  // Out of bounds or already filled
        }
        matrix[i][j] = 'X';  // Mark as filled

        fill(i + 1, j, m, n, matrix);
        fill(i - 1, j, m, n, matrix);
        fill(i, j + 1, m, n, matrix);
        fill(i, j - 1, m, n, matrix);
    }
}

}
