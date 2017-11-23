/**
 * Created by nimbekl on 11/15/17.
 */
public class MinimumPathAlgo {
    public static void main(String args[]){
        int graph[][] = new int[][]{
                {0, 0, 0, 0, 0},
                {1, 9, 9, 9, 1},
                {0, 0, 0, 0, 0}
        };
        ShortestPath t = new ShortestPath();
        int [] result = t.dijkstra(graph, 0);
        for(int i = 0;i<result.length;i++){
           System.out.println(result[i]);
        }
    }
}
class ShortestPath {
    int[] dijkstra(int[][] graph,int src){
        final int V= graph[0].length;
        //output array to store shortest psth from src to destination
        int dist[] = new int[V];
        //array for marking visited nodes;
        boolean visited[] = new boolean[V];
        //initialize all distances as maximum value
        for(int i = 0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[src] = 0;//distance of source from itself will be zero
        //find shortest path for all vertices
        for(int i = 0;i <graph.length;i++){
            //find min distance from vertices not yet picked
            int u = minDistance(dist,visited);
            visited[u] = true;
            for(int v = 0;v<V;v++) {
                //update distance for v if visited for v is false and current distance at v is bigger than new distance
                if(!visited[v] && graph[i][v] != 0 && dist[i] != Integer.MAX_VALUE && dist[i]+graph[i][v]>dist[v]){
                    dist[v] = dist[i]+graph[i][v];
                }
            }
        }
        return dist;
    }
    int minDistance(int dist[], boolean visited[]) {
        //initialize min value
        int min = Integer.MIN_VALUE, minIndex = 0;
        for(int i = 0;i<dist.length;i++){
          if(visited[i] == false && dist[i] <= min){
                min = dist[i];
                minIndex = i;
          }
        }
        return minIndex;
    }
}
