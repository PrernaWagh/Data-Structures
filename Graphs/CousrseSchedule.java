import java.util.ArrayList;

public class CousrseSchedule {
      private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        int[] vis, int[] pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {

            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis))
                    return true;
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

       
        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return false; // cycle found
                }
            }
        }

        return true; // no cycle found
    }
}