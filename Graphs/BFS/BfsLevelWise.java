import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsLevelWise {
    public ArrayList<ArrayList<Integer>> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                for (int child : adj.get(temp)) {
                    if (!visited[child]) {
                        visited[child] = true;
                        q.offer(child);
                    }
                }
                list.add(temp);
            }
            ans.add(list);
        }
        return ans;
    }
}
