package J21_Graph;
import java.util.*;
public class G12_Bipartite_Graph {
    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        boolean ans = isBipartiteBfs(4, adj);
        boolean ans2 = isBipartiteDfs(4,adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }
    public static boolean isBipartiteBfs(int V, ArrayList<ArrayList<Integer>>adj) {
        int color[] = new int[V];
        for(int i = 0;i<V;i++) color[i] = -1;

        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(checkBfs(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean checkBfs(int start, int V, ArrayList<ArrayList<Integer>>adj, int color[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if(color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                // is the adjacent guy having the same color
                // someone did color it on some other path
                else if(color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartiteDfs(int V, ArrayList<ArrayList<Integer>>adj) {
        int color[] = new int[V];
        for(int i = 0;i<V;i++) color[i] = -1;

        // for connected components
        for(int i = 0;i<V;i++) {
            if(color[i] == -1) {
                if(dfs(i, 0, color, adj)) return false;
            }
        }
        return true;
    }
    private static boolean dfs(int node, int col, int color[],ArrayList<ArrayList<Integer>>adj) {

        color[node] = col;
        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj)) return false;
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false;
            }
        }
        return true;
    }
}
