package DsAndAlgo.Graph;

/**
 * Created by nimbekl on 11/10/17.
 */

public class DetectNegetiveCycle {
    int V;
    int edge;
    Edge [] edges;

    DetectNegetiveCycle(int V,int edge){
        this.V = V;
        this.edge = edge;
        edges = new Edge[edge];
    }

    static class Edge{
        int src;
        int destination;
        int weight;
        Edge(int src,int destination,int weight){
            this.src = src;
            this.weight = weight;
            this.destination = destination;
        }
    }

    static void hasNegetiveCycle(DetectNegetiveCycle graph,int source){
        int count = graph.edges[source].weight;
        int next = graph.edges[source].destination;
        while(source != next ){
            count += graph.edges[next].weight;
            next = graph.edges[next].destination;
        }
        if(count < 0){
          System.out.println("true");
        }else System.out.println("false");
    }

    public static void main(String args[]){
        DetectNegetiveCycle graph = new DetectNegetiveCycle(5,8);
        graph.edges[0] = new Edge(0,1,-1);
        graph.edges[1] = new Edge(0,2,4);
        graph.edges[2] = new Edge(1,2,3);
        graph.edges[3] = new Edge(1,3,2);
        graph.edges[4] = new Edge(1,4,2);
        graph.edges[5] = new Edge(3,2,5);
        graph.edges[6] = new Edge(3,1,1);
        graph.edges[7] = new Edge(4,3,-3);
        hasNegetiveCycle(graph,0);
    }
}
