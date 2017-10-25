/**
 * Created by nimbekl on 10/7/17.
 */
import java.util.*;
public class nodesAtLevel {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int totalNodes = s.nextInt();
        HashMap<Integer, Node> graph = new HashMap<>();
        for(int i = 1;i<=totalNodes;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            graph.put(a,new Node(a));
            graph.put(b,new Node(b));
        }
    }

    static class Node{
        int data;
        ArrayList<Node> child;
        Node(int data){
            this.data = data;
        }
    }
}
