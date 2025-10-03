class Solution {
    long maxScore = 0;
    int count = 0;
    int n;
    
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parents[i]).add(i);
        }
        
        dfs(0, children);
        return count;
    }
    
    public int dfs(int node, List<List<Integer>> children) {
        int size = 1;
        long score = 1;
        
        for (int child : children.get(node)) {
            int childSize = dfs(child, children);
            size += childSize;
            score *= childSize;
        }
        
        int remaining = n - size;
        if (node != 0) {
            score *= remaining;
        }
        
        if (score > maxScore) {
            maxScore = score;
            count = 1;
        } else if (score == maxScore) {
            count++;
        }
        
        return size;
    }
}
