
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    private void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int it : adj.get(node))
        {
            if(vis[it] == 0)
            {
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[V];
        int index = 0;
        for(int i =0;i<V;i++)
        {
            if(vis[i] == 0)
            {
                dfs(i,vis,st,adj);
            }
        }
        while(!st.isEmpty())
        {
            ans[index] = st.pop();
            index++;
        }
        return ans;
    }
}
