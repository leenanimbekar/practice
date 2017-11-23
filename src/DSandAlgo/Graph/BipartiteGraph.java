package DsAndAlgo.Graph;

/**
 * Created by nimbekl on 11/13/17.
 */
import java.util.*;
public class BipartiteGraph {
    public static void main(String args[]){
        int G[][] = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        BipartiteGraph b = new BipartiteGraph();
        System.out.print(b.isBipartite(G));
    }
    boolean isBipartite(int[][] graph){
        int[] vertex = new int[graph.length];
        Arrays.fill(vertex,-1);
        vertex[0] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex[0]);
        while(!queue.isEmpty()){
            int element = queue.poll();
            if(graph[element][element] == 1){
                return false;
            }
            for(int u = 0;u<vertex.length;u++){
                if(graph[element][u] == 1 && vertex[u] == -1){
                   vertex[u] = 1-vertex[element];
                   queue.add(u);
                }else if(graph[element][u] == 1 && vertex[u] == vertex[element]){
                    return false;
                }
            }
        }
      return true;
    }
}
