/**
 * Created by nimbekl on 11/4/17.
 */
public class rootToLeafPath {
    static Node root;
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    static void printPath(Node node,int sum){
        int path[] = new int[1000];
        printPathRecur(path,node,0,sum);
    }
    static void printPathRecur(int [] path,Node node,int pathLength,int sum){
        if(node == null){
            return;
        }
        path[pathLength] = node.data;
        pathLength++;
        if(node.left == null && node.right == null){
            int j = 0;
            for(int i = 0;i<pathLength;i++){
               System.out.print(path[i]);
                j += path[i];
            }
            if(j == sum){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
            System.out.println();
        }
        else{
            printPathRecur(path,node.left,pathLength,sum);
            printPathRecur(path,node.right,pathLength,sum);
        }
    };
    public static void main(String args[]){
        rootToLeafPath tree = new rootToLeafPath();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        printPath(root,14);
    }
}
