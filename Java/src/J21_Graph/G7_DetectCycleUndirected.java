package J21_Graph;
import java.util.*;
class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class G7_DetectCycleUndirected {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycleBfs(4, adj);
        boolean ans2= isCycleDfs(4,adj);
        if (ans && ans2)
            System.out.println("1");
        else
            System.out.println("0");
    }
    static boolean BfsCycleCheck(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean vis[], int parent[]) {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1));
        vis[s] =true;
        while(!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for(Integer it: adj.get(node)) {
                if(vis[it]==false)
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                else if(par != it) return true;
            }
        }
        return false;
    }
    public static boolean isCycleBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(BfsCycleCheck(adj, i,vis, parent))
                    return true;

        return false;
    }



    private static boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>>
            adj) {
        vis[node] = 1;
        // go to all adjacent nodes
        for(int adjacentNode: adj.get(node)) {
            if(vis[adjacentNode]==0) {
                if(dfs(adjacentNode, node, vis, adj))
                    return true;
            }
            // if adjacent node is visited and is not its own parent node
            else if(adjacentNode != parent) return true;
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public static boolean isCycleDfs(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
}
