/**
 * Created by nimbekl on 11/5/17.
 */
public class PrintMaxPath {
    static Node root;
    static int val;
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static int printMax(Node node){
        if(node == null){
            return 0;
        }else{
          int l =  printMax(node.left);
          int r =  printMax(node.right);
          int max = Math.max(Math.max(l,r)+node.data,node.data);
          int max_top = Math.max(max,l+r+node.data);
          val = Math.max(val,max_top);
          return max;
        }
    }
    public static void main(String args[]){
        PrintMaxPath t = new PrintMaxPath();
        t.root = new Node(10);
        t.root.left = new Node(2);
        t.root.right = new Node(10);
        t.root.left.left = new Node(20);
        t.root.left.right = new Node(1);
        t.root.right.right = new Node(-25);
        t.root.right.right.left = new Node(3);
        t.root.right.right.right = new Node(4);
        printMax(root);
        System.out.println(val);
    }
}
