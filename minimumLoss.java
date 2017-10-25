import java.util.*;
import java.io.*;

public class minimumLoss {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        long years = s.nextInt();
        BST b = new BST();
        for (int i = 0; i < years; i++) {
            b.insert(s.nextLong());
        }
        s.close();
        b.inorder();
    }
}
class BSTNode {

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode left;
    public BSTNode right;
    long data;

    public BSTNode() {
         right = null;
         left = null;
         data = 0;
    }
    public BSTNode(long n)
    {
        left = null;
        right = null;
        data = n;
    }

}

class BST {

    private BSTNode root ;
    long min = 0;

    BST(){
       root = null;
    }

    public void insert(long data){
        root = insert(root,data);
    }
    private BSTNode insert(BSTNode node ,long data){
        if(node == null){
           node = new BSTNode(data);
        }
        else {
            if(data <= node.getData()){
                node.left = insert(node.left, data);
            }
            else node.right = insert(node.right, data);
        }
        return node;
    }
    public void inorder(){
        inorder(root);
        System.out.println(min);
    }
    private void inorder(BSTNode node){
        if(node != null) {
            inorder(node.getLeft());
            if(node.getLeft()!=null){
                BSTNode newNode = node.getLeft();
                while(newNode.getRight()!=null){
                    newNode = newNode.getRight();
                }
                long finalDiff = node.getData() - newNode.getData();
                if (min == 0) {
                    min = finalDiff;
                } else if (min > finalDiff) {
                    min = finalDiff;
                }
            }
            inorder(node.getRight());
        }
    }

}
