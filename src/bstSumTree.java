/**
 * Created by nimbekl on 10/23/17.
 *//*

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
class BSTree{
    Node root;
    void addNode(int data){
        root = addNode(root,data);
    }
    Node addNode(Node node, int data){
        if(node == null){
            node = new Node(data);
        }
        else {
            if(data > node.data){
                node.right = addNode(node.right,data);
            }else node.left = addNode(node.left,data);
        }
        return node;
    }
    void inorder(BSTree tree){
        inorder(tree.root);
    }
    void inorder(Node node){
        if(node.left!= null){
            inorder(node.left);
        };
        System.out.print(node.data+" ");
        if(node.right!=null){
            inorder(node.right);
        }
    }
    void sumBSTree(Node n,Sum s){
        if(n == null){
            return;
        }
        sumBSTree(n.right,s);
        s.sum = n.data +s.sum;
        n.data = s.sum - n.data;
        sumBSTree(n.left, s);
    }
}
class Sum{
    int sum = 0;
}
public class bstSumTree {

    public static void main(String args[]){
        BSTree bst = new BSTree();
        bst.addNode(11);
        bst.addNode(2);
        bst.addNode(29);
        bst.addNode(1);
        bst.addNode(7);
        bst.addNode(15);
        bst.addNode(40);
        bst.addNode(35);

        bst.inorder(bst);
        System.out.println();
        bst.sumBSTree(bst.root,new Sum());
        bst.inorder(bst);
    }
}
*/
