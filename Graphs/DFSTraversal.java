package Graphs;
import java.util.ArrayList;
import java.util.Scanner;

public class DFSTraversal {
    public static ArrayList<ArrayList<Integer>> createGraph(int n,int m,Scanner sc)
    {
        int src,dest;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        

        for(int i = 0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            System.out.println("Enter edge "+(i+1)+" (src dest) : ");
            src = sc.nextInt();
            dest = sc.nextInt();

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        return adj;
    }
    public static void displayList(ArrayList<ArrayList<Integer>> adj,int n)
    {
        System.out.println("Adjacency List : ");
        for(int i=1;i<=n;i++)
        {
            System.out.print(i + " -> ");
            for(int vertex : adj.get(i))
            {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
    public static void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfsList)
    {
        vis[node] = true;
        dfsList.add(node);

        for(Integer it:adj.get(node))
        {
            if(vis[it] == false)
            {
                dfs(it,vis,adj,dfsList);
            }
        }
    }
    public static ArrayList<Integer> dfsTraversal(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V + 1];
        ArrayList<Integer> dfsList = new ArrayList<>();
        dfs(1,vis,adj,dfsList);
        return dfsList;
    }
    public static void main(String s[])
    {
        
        int n = 0;
        int m = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> dfs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes : ");
        n = sc.nextInt();
        System.out.println("Enter number of edges : ");
        m = sc.nextInt();
        adjList = createGraph(n,m,sc);

        displayList(adjList, n);
        dfs = dfsTraversal(n, adjList);
        System.out.println("DFS traversal is : ");
        for(Integer i : dfs)
        {
            System.out.print(i+" ");
        }

    }
}

//output:-
// Enter number of nodes : 
// 8
// Enter number of edges : 
// 8
// Enter edge 1 (src dest) : 
// 1
// 2
// Enter edge 2 (src dest) : 
// 1

// 3
// Enter edge 3 (src dest) : 

// 2
// 5
// Enter edge 4 (src dest) : 
// 2
// 6
// Enter edge 5 (src dest) : 
// 3
// 4
// Enter edge 6 (src dest) : 
// 3
// 7
// Enter edge 7 (src dest) : 
// 7
// 8
// Enter edge 8 (src dest) : 
// 4
// 8
// Adjacency List : 
// 1 -> 2 3 
// 2 -> 1 5 6 
// 3 -> 1 4 7 
// 4 -> 3 8 
// 5 -> 2 
// 6 -> 2 
// 7 -> 3 8 
// 8 -> 7 4 
//  DFS traversal is : 
// 1 2 5 6 3 4 8 7 