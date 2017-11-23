package DsAndAlgo.Graph;

import java.util.*;

/**
 * Created by nimbekl on 11/7/17.
 */
public class BFS {
    Node root;
    private Queue<Node> queue;
    BFS(){
        queue =  new LinkedList<Node>();
    }
    public static void main(String args[]){
        ArrayList<Node> lst = new ArrayList<>();
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        lst.add(node40);
        lst.add(node10);
        lst.add(node20);
        lst.add(node30);
        lst.add(node60);
        lst.add(node50);
        lst.add(node70);
        int adjacency_matrix[][] = {
                {0,1,1,0,0,0,0}, // Node 1: 40
                {0,0,0,1,0,0,0}, // Node 2 :10
                {0,1,0,1,1,1,0}, // Node 3: 20
                {0,0,0,0,1,0,0}, // Node 4: 30
                {0,0,0,0,0,0,1}, // Node 5: 60
                {0,0,0,0,0,0,1}, // Node 6: 50
                {0,0,0,0,0,0,0}, // Node 7: 70
        };
        BFS bfs = new BFS();
        bfs.bfs(node40,adjacency_matrix,lst);
    }
    void bfs(Node node,int[][] adjacency_matrix,ArrayList<Node> lst){
        queue.add(node);
        node.visited = true;
        while(!queue.isEmpty()){
          Node tempNode = queue.remove();
           System.out.print(tempNode.data+" ");
            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix,tempNode,lst);
            for(int i = 0;i<neighbours.size();i++){
              Node n = neighbours.get(i);
                if(n != null && !n.visited){
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
    ArrayList<Node> findNeighbours(int[][] adjacency_matrix,Node node,ArrayList<Node> lst){
        int index = -1;
        ArrayList<Node> neighbours = new ArrayList<>();
        for(int i = 0;i<lst.size();i++){
            if(lst.get(i).data==node.data){
                index = i;
                break;
            }
        }
        if(index != -1) {
            for (int i = 0; i < adjacency_matrix[index].length; i++) {
                if (adjacency_matrix[index][i] == 1) {
                    neighbours.add(lst.get(i));
                }
            }
        }
        return neighbours;
    }
    static class Node{
        int data;
        boolean visited;
        Node(int data){
            this.data = data;
        }
    }
}
