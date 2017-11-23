package DsAndAlgo.Graph;

import java.util.*;

public class DFS {
    Node root;
    public static void main(String args[]){
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);
        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);
        DFS dfs = new DFS();
        System.out.println("Iterative");
        dfs.dfsIterative(node40);
        node40.visited=false;
        node10.visited=false;
        node20.visited=false;
        node30.visited=false;
        node60.visited=false;
        node50.visited=false;
        node70.visited=false;
        System.out.println();
        System.out.println("Recursive");
        dfs.dfsRecursive(node40);
    }
    void dfsIterative(Node node){
       if(node == null)return;
        Stack<Node> s = new Stack();
        s.add(node);
        while(!s.isEmpty()){
            Node tempNode = s.pop();
            System.out.print(tempNode.data+" ");
            tempNode.visited =  true;
            List<Node> neighbours = tempNode.getneighbours();
            for(int i = 0;i<neighbours.size();i++){
                Node currentNode = neighbours.get(i);
                if(currentNode != null && !currentNode.visited){
                    s.push(currentNode);
                    currentNode.visited=true;
                }
            }
        }
    }
    void dfsRecursive(Node node){
      if(node == null)return;
      System.out.print(node.data+" ");
      node.visited = true;
      List<Node> neighbours = node.getneighbours();
        for(int i = 0;i<neighbours.size();i++){
            Node tempNode = neighbours.get(i);
            if(tempNode!= null && !tempNode.visited){
                dfsRecursive(tempNode);
            }
        }
    }
    static class Node{
        int data;
        boolean visited;
        List<Node> neighbours;
        Node(int data){
         this.data = data;
         this.neighbours = new ArrayList<>();
        }
        public void addneighbours(Node node){
            this.neighbours.add(node);
        }
        public List<Node> getneighbours(){
            return neighbours;
        }
        public void setneighbours(List<Node> neighbours){
            this.neighbours = neighbours;
        }
    }
}