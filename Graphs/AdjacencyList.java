package Graphs;
import java.util.ArrayList;
import java.util.Scanner;
public class AdjacencyList {
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
    public static void main(String s[])
    {
        int n = 0;
        int m = 0;
        int src,dest;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes : ");
        n = sc.nextInt();
        System.out.println("Enter number of edges : ");
        m = sc.nextInt();

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

        displayList(adj, n);

    }
}
