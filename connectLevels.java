import java.util.*;
import java.util.LinkedList;

/**
 * Created by nimbekl on 10/31/17.
 */
public class connectLevels {

    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        connect(root);
        System.out.println("Following are populated nextRight pointers in \n" +
                "the tree (-1 is printed if there is no nextRight)");
        System.out.println("nextRight of "+ root.data +" is "+
                ((root.nextRight != null) ? root.nextRight.data : -1));
        System.out.println("nextRight of "+ root.left.data+" is "+
                ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
        System.out.println("nextRight of "+ root.right.data+" is "+
                ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
        System.out.println("nextRight of "+  root.left.left.data+" is "+
                ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
        System.out.println("nextRight of "+  root.right.right.data+" is "+
                ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
    }
    static void connect(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        while(!q.isEmpty()){
            Node p = q.peek();
            q.remove();
            if(p != null){
                p.nextRight = q.peek();
                if(p.left != null){
                  q.add(p.left);
                }
                if(p.right != null){
                    q.add(p.right);
                }
            }else if(!q.isEmpty()){
               q.add(null);
            }
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
        }
    }
   /* class Tree{
        Node root;
        void addNode (int n ){
           root = addNode(root,n);
        }
        Node addBSTNode (Node node,int n ){
            if(node == null){
                node = new Node(n);
            }else{
                if(n < node.data){
                    node.left = addBSTNode(node.left,n);

                }else {
                    node.right = addBSTNode(node.right,n);
                }
            }
            return node;
        }
    }*/
}

