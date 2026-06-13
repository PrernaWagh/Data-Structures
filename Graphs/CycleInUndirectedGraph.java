import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraph {
     class Pair {
       int node;
       int parent;

       Pair(int node,int parent)
       {
        this.node = node;
        this.parent = parent;
       }
    }
    public boolean checkForCycle(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));

        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            for(int adjNode : adj.get(node))
            {
                if(vis[adjNode] == false)
                {
                    q.add(new Pair(adjNode,node));
                    vis[adjNode] = true;
                }
                else if(parent != adjNode)
                {
                    return true;
                }
            }
        }
        return false;

    }
}
