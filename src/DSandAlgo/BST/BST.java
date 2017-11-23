package DsAndAlgo.BST;

/**
 * Created by nimbekl on 11/7/17.
 */
public class BST {
    Node root;
    BST(){
        root = null;
    }
    public static void main(String args[]){
        BST t = new BST();
        t.add(40);
        t.add(20);
        t.add(60);
        t.add(10);
        t.add(30);
        t.add(50);
        t.add(70);
        t.add(5);
        t.add(55);
        t.inorder(t.root);
        System.out.println();
        t.delete(40);
        t.inorder(t.root);
        System.out.println();
    }
    void delete(int key){
     root = deleteRecord(root,key);
    }
    Node deleteRecord(Node node,int n){
        if(node == null)return null;
        if(node.data>n){
            node.left = deleteRecord(node.left,n);
        }else if(node.data<n){
            node.right = deleteRecord(node.right,n);
        }else {
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                node.data = minValue(node.right);
                node.right = deleteRecord(node.right,node.data);
            }
        }
        return node;
    }
    int minValue(Node node){
        int min = node.data;
        while(node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
    void inorder(Node node){
      if(node==null)return;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);
    }
    void add(int n){
       root = addNext(root,n);
    }
    Node addNext(Node node,int n){
       if(node==null)return new Node(n);
        if(node.data > n) {
            node.left = addNext(node.left, n);
        }else node.right = addNext(node.right, n);
        return node;
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
}
