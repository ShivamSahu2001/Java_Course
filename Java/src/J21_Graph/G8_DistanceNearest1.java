package J21_Graph;
import java.util.*;
class pair1 {
    int first;
    int second;
    int third;
    pair1(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class G8_DistanceNearest1 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };
        int[][] ans = nearest(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // visited and distance matrix
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        // <coordinates, steps>
        Queue<pair1> q = new LinkedList<pair1>();
        // traverse the matrix
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // start BFS if cell contains 1
                if(grid[i][j] == 1) {
                    q.add(new pair1(i, j, 0));
                    vis[i][j] = 1;
                }
                else {
                    // mark unvisted
                    vis[i][j] = 0;
                }
            }
        }
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, +1, 0, -1};// n x m x 4
        // traverse till queue becomes empty
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            // for all 4 neighbours
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid unvisited cell
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0)  {
                    vis[nrow][ncol] = 1;
                    q.add(new pair1(nrow, ncol, steps+1));
                }
            }
        }
        return dist;
    }
}
