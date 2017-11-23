package DsAndAlgo.BinaryTree;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by nimbekl on 11/6/17.
 */
public class Traversal {
    public static void main(String args[]){
        BinaryTree t = new BinaryTree();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        t.preOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.levelOrder(t.root);
        System.out.println();
        t.spiralOrder(t.root);
        System.out.println();
        int n = t.printLeafNodes(t.root);
        System.out.println();
        System.out.println(n);
        t.printRootToLeafPaths(t.root);
        System.out.println(t.getLevel(t.root,4));
        System.out.println();
        t.boudryTraversal(t.root);
        System.out.println(t.LowestCommonAncestor(t.root,5,6).data);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        t.verticalSum(t.root,mp,0);
        for(Entry<Integer,Integer> entry:mp.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
         this.data = data;
        }
    }
    static class BinaryTree{
        Node root;
        Queue<Node> q;
        BinaryTree(){
           root = null;
           q = new LinkedList<>();
        }
         void verticalSum(Node node,TreeMap<Integer,Integer> mp,int level){
            if(node == null)return;
             verticalSum(node.left,mp,level-1);
             if(mp.containsKey(level)){
               int val = mp.get(level);
                 mp.put(level,node.data+val);
             }else mp.put(level,node.data);
             verticalSum(node.right,mp,level+1);
         }
         Node LowestCommonAncestor(Node node,int a ,int b){
            if(node ==  null)return null;
            if(node.data == a || node.data == b){
                return node;
            }
            Node left = LowestCommonAncestor(node.left,a,b);
            Node right = LowestCommonAncestor(node.right,a,b);
             if(left != null && right!= null){
                return node;
             }
             if(left == null){
                return right;
             }else return left;
        }
        void boudryTraversal(Node node){
            if(node == null)return;
            System.out.print(node.data);
            boundryTraversalLeft(node.left);
            boundryTraversalLeaf(node);
            boundryTraversalRight(node.right);
        }
        void boundryTraversalLeft(Node node){
           if(node == null)return;
            if(node.left==null && node.right==null)return;
            System.out.print(node.data);
            if(node.left==null) {
                boundryTraversalLeft(node.left);
            }else boundryTraversalLeft(node.right);
        }
        void boundryTraversalLeaf(Node node){
            if(node == null)return;
            if(node.left==null && node.right==null) {
                System.out.print(node.data);
                return;
            }
            boundryTraversalLeaf(node.left);
            boundryTraversalLeaf(node.right);
        }
        void boundryTraversalRight(Node node){
            if(node == null)return;
            if(node.left==null && node.right==null)return;
            System.out.println(node.data);
            if(node.right == null){
                boundryTraversalRight(node.left);
            }
            else boundryTraversalRight(node.right);
        }
        int getLevel(Node node,int i){
            return getLevelUtil(node ,i,1);
        }
        int getLevelUtil(Node node,int data,int level){
           if(node == null)return 0;
            if(node.data == data){
                return level;
            }
           int downlevel =  getLevelUtil(node.left,data,level+1);
            if(downlevel !=0){
               return downlevel;
            }
            downlevel = getLevelUtil(node.right,data,level+1);
            if(downlevel !=0){
               return downlevel;
            }
            return 0;
        }
        void printRootToLeafPaths(Node node){
          int[] arr = new int[100];
            printPathRecur(node,arr,0);
        }
        void printPathRecur(Node node,int[] arr,int pathLength){
          if(node == null)return;
          arr[pathLength] = node.data;
          pathLength++;
            if(node.left==null&&node.right==null){
                for(int i = 0;i<pathLength;i++){
                   System.out.print(arr[i]);
                }
                System.out.println();
            }else{
                printPathRecur(node.left,arr,pathLength);
                printPathRecur(node.right,arr,pathLength);
            }
        }
        void add(int n){
            Node node = new Node(n);
            if(root == null){
              root = new Node(n);
            }
            else {
                q.add(root);
                addNode(root,node,q);
            }
        }
        void addNode(Node node,Node newNode,Queue<Node> q){
            while(!q.isEmpty()){
             node = q.peek();
             q.remove();
             if(node.left == null){
                node.left = newNode;
                break;
             }else{
                 q.add(node.left);
             }
             if(node.right == null){
                 node.right = newNode;
                 break;
             }else{
                 q.add(node.right);
             }
            }
        }
        void preOrder(Node node){
            System.out.print(node.data+" ");
            if(node.left!=null){
                preOrder(node.left);
            }
            if(node.right != null) {
                preOrder(node.right);
            }
        }
        void postOrder(Node node){
            if(node.left!=null){
                postOrder(node.left);
            }
            if(node.right != null) {
                postOrder(node.right);
            }
            System.out.print(node.data+" ");
        }
        void inOrder(Node node){
            if(node.left!=null){
                inOrder(node.left);
            }
            System.out.print(node.data+" ");
            if(node.right != null) {
                inOrder(node.right);
            }
        }
        void levelOrder(Node node){
            Queue<Node> q = new LinkedList();
            q.add(node);
            while(!q.isEmpty()){
                Node temp = q.poll();
                System.out.print(temp.data+" ");
                if(temp.left != null){
                   q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        void spiralOrder(Node node){
            if(root == null){
               return;
            }
                Stack<Node> s = new Stack();
                s.push(node);
                boolean directionFlag = false;
                while(!s.isEmpty()){
                    Stack<Node> tempStack = new Stack();
                    while(!s.isEmpty()){
                        Node tempNode = s.pop();
                        System.out.print(tempNode.data+" ");
                        if(!directionFlag){
                            if(tempNode.left != null){
                                tempStack.push(tempNode.left);
                            }
                            if(tempNode.right != null){
                                tempStack.push(tempNode.right);
                            }
                        }else{
                            if(tempNode.right != null){
                                tempStack.push(tempNode.right);
                            }
                            if(tempNode.left != null){
                                tempStack.push(tempNode.left);
                            }
                        }
                    }
                    directionFlag = !directionFlag;
                    s = tempStack;
                }
            }
        int printLeafNodes(Node node){
            if(node == null) return 0;
            if(node.left == null && node.right==null){
                System.out.print(node.data+ " ");
                return 1;
            }
            return printLeafNodes(node.left)+printLeafNodes(node.right);
        }
    }
}
