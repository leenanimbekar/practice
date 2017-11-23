import java.io.Serializable;

/**
 * Created by nimbekl on 10/24/17.
 */
class Node{
    int data;
    Node left;
    Node right;
    Node next;
    int index;
    Node(int data){
        this.data = data;
    }
}
class LinkedList{
    Node head;
    void addNode(int data){
        head = addNode(head,data);
    }
    Node addNode(Node node,int data){
        if(node == null){
            node = new Node(data);
        }
        else {
            int index = node.index;
            node.next = addNode(node.next,data);
            node.next.index = ++index;
        }
       return node;
    }
    Node getNode(int index){
        Node current = head;
        int count = 0;
        while(current != null){
            if(count == index) {
                return current;
            }
            else{
                count++;
                current = current.next;
            }
        }
        return current;
    }

    int getLength(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    Node sortedListToBST(){
        int n = getLength();
        return sortedListToBST(n);
    }

    Node sortedListToBST(int n){
        if (n <= 0) {
            return null;
        }
        Node left = sortedListToBST(n/2);
        Node root = new Node(head.data);
        root.left = left;
        head = head.next;
        root.right = sortedListToBST(n - n/2 - 1);
        return root;

    }
}
class BSTree{
    Node root;
    /*void addNode(int data){
        root = addNode(root,data);
    }
    Node addNode(Node node,int data){
        if(node == null){
            node = new Node(data);
        }
        else {
            if(data < node.data ){
                node.left = addNode(node,data);
            }else node.right = addNode(node,data);
        }
       return node;
    }*/
    void preorder(Node node){
        if(node == null){
          return;
        }
        else{
           System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
}
public class sortedLinkedListToTree {
    public static void main(String args[]){
        LinkedList lst = new LinkedList();
        lst.addNode(1);
        lst.addNode(2);
        lst.addNode(3);
        lst.addNode(4);
        lst.addNode(5);
        lst.addNode(6);
        BSTree tree = new BSTree();
        Node n = lst.sortedListToBST();
        tree.preorder(n);
    }
}
