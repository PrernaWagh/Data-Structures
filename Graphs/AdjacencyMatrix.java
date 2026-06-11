package Graphs;

import java.util.Scanner;
public class AdjacencyMatrix {
    public static void displayMatrix(int[][] adj, int n) {

        System.out.println("Adjacency matrix is : ");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String s[]) {
        int n = 0;
        int m = 0;
        int src,dest;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes : ");
        n = sc.nextInt();
        System.out.println("Enter number of edges : ");
        m = sc.nextInt();

        int[][] adj = new int[n+1][n+1];

        for(int i=0;i<m;i++)
        {
            System.out.println("Enter edge "+(i+1)+" (src dest) : ");
            src = sc.nextInt();
            dest = sc.nextInt();

            adj[src][dest] = 1;
            adj[dest][src] = 1;
        }

        displayMatrix(adj, n);
        
    }
}
