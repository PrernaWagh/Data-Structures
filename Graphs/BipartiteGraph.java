
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    boolean check(int start,int V,ArrayList<ArrayList<Integer>> adj,int color[])
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = -1;

        while(!q.isEmpty())
        {
            int node = q.poll();
            q.remove();

            for(Integer it:adj.get(node))
            {
                if(color[it] == -1)  
                {
                    color[it] = 1-color[node];
                    q.add(it);
                }
                else if(color[it] == color[node])
                {
                    return false;
                }
            }
        }
        return true;   
    }
    boolean isBipartitie(int V,ArrayList<ArrayList<Integer>> adj) 
    {
        int[] color = new int[V];
        for(int i=0;i<V;i++)  
        {
            color[i] = -1;
        }
        for(int i=0;i<V;i++)    
        {
            if(color[i] == -1)  
            {
                if(check(i,V,adj,color) == false)  
                {
                    return false;
                }
            }
        }
        return true;
    }
}
