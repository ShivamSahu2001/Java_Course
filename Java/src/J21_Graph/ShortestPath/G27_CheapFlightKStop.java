package J21_Graph.ShortestPath;
import java.util.*;
class Double{
    int first;
    int second;
    public Double(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Triple{
    int first, second, third;
    Triple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class G27_CheapFlightKStop {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int ans = CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();
    }
    public static int CheapestFLight(int n,int flights[][],int src,int dst,int K) {
        ArrayList<ArrayList<Double>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Double(flights[i][1], flights[i][2]));
        }
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(0, src, 0));
        int[] dist = new int[n];
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        while(!q.isEmpty()) {
            Triple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;
            if(stops > K) continue;
            for(Double iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;
                if (cost + edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edW;
                    q.add(new Triple(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
