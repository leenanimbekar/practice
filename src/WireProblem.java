/**
 * Created by nimbekl on 11/3/17.
 */
import java.util.*;
import java.util.LinkedList;

public class WireProblem {
    static Double val = 0.0;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        Edge[] arr = new Edge[num];
        for(int i = 0;i<num-1;i++){
            arr[i] = new Edge(s.nextInt(),s.nextInt());
        }
        Node root = null;
        Queue<Node> q = new LinkedList<>();
        for(int i = 1;i<=num;i++){
            if(i == 1){
                root = new Node(i);
            }
            else {
                q.add(root);
                Node.addNode(root,i,q);
            }
        }
        int total = getSize(root);
        getProbabiility(root,root,total);
        System.out.println(val);
    }
    static void getProbabiility(Node node,Node root,int total){
        if(node == null){
            return;
        }else {
            int levelProb = getLevel(root,node.data);
            int lsize = getSize(node.left);
            if(lsize != 0) {
                val += Double.valueOf(levelProb) / 10 * (total - lsize);
            }
            int rsize = getSize(node.right);
            if(rsize != 0){
                val += Double.valueOf(levelProb) / 10 * (total - rsize);
            }
            getProbabiility(node.left,root,total);
            getProbabiility(node.right,root,total);
        }
    }
    static Node getNode(Node node,int data){
        if(node != null){
            if(node.data == data){
                return node;
            }else {
                Node current = getNode(node.left,data);
                if(current == null){
                    current = getNode(node.right,data);
                }
                return current;
            }
        }else return null;
    }
    static int getSize(Node node){
        if(node == null){
            return 0;
        }else {
            int lSize = getSize(node.left);
            int rSize = getSize(node.right);
            return lSize + rSize + 1;
        }
    }
    static class Edge{
        int data;
        int next;
        Edge(int data,int next){
            this.data = data;
            this.next = next;
        }
    }
    static int getHeight(Node node){
        if(node == null){
            return 0;
        }
        else {
            int lDepth = getHeight(node.left);
            int rDepth = getHeight(node.right);
            if(lDepth > rDepth){
                return lDepth+1;
            }else return rDepth+1;
        }
    }
    static int getLevelUtil(Node node,int data,int level) {
        if (node == null) {
            return 0;
        }
        if (node.data == data) {
            return level;
        }
        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevelUtil(node.right, data, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        return 0;
    }
    static int getLevel(Node n,int i){
        return getLevelUtil(n,i,1);
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
          this.data = data;
        }
        static void addNode(Node node,int data,Queue q){
            while (!q.isEmpty()) {
                node = (Node)q.peek();
                q.remove();
                if (node.left == null) {
                    node.left = new Node(data);
                    break;
                } else q.add(node.left);
                if (node.right == null) {
                    node.right = new Node(data);
                    break;
                } else q.add(node.right);
            }
        }
    }
}
