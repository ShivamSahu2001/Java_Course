package J21_Graph.ShortestPath;
import java.util.*;
import java.lang.*;
import java.io.*;
class Pair4 {
    int first, second;
    Pair4(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
public class G19_ShortestPathDAG {
    public static void main(String[] args) throws IOException {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int res[] = shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
    private static void topoSort(int node, ArrayList < ArrayList < Pair4 >> adj, int vis[], Stack < Integer > st) {
       vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public static int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList < ArrayList < Pair4 >> adj = new ArrayList < > ();
        for (int i = 0; i < N; i++) {
            ArrayList < Pair4 > temp = new ArrayList < Pair4 > ();
            adj.add(temp);
        }for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair4(v, wt));
        }
        int vis[] = new int[N];
        //Now, we perform topo sort using DFS technique
        //and store the result in the stack st.

        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        int dist[] = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
        }
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}
