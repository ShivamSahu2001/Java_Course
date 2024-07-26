package J21_Graph.ShortestPath;
import java.util.*;
class Pair7{
    int first;
    int second;
    public Pair7(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class G24_PrintShortestPDijkstra {
    public static void main(String[] args) {
        int V = 5, E = 6;
        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        List < Integer > path = shortestPath(V, E, edges);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair7>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(new Pair7(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair7(edges[i][0], edges[i][2]));
        }

        // Create a priority queue for storing the nodes along with distances
        // in the form of a pair { dist, node }.
        PriorityQueue<Pair7> pq =
                new PriorityQueue<Pair7>((x,y) -> x.first - y.first);

        // Create a dist array for storing the updated distances and a parent array
        //for storing the nodes from where the current nodes represented by indices of
        // the parent array came from.
        int[] dist = new int[n+1];
        int[] parent =new int[n+1];
        for(int i = 1;i<=n;i++) {
            dist[i] = (int)(1e9);
            parent[i] = i;
        }

        dist[1] = 0;

        // Push the source node to the queue.
        pq.add(new Pair7(0, 1));
        while(pq.size() != 0) {
            Pair7 it = pq.peek();
            int node = it.second;
            int dis = it.first;
            pq.remove();

            // Iterate through the adjacent nodes of the current popped node.
            for(Pair7 iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;
                if(dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair7(dis + edW, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }
        int node = n;
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
