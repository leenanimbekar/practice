package DsAndAlgo;

/**
 * Created by nimbekl on 11/5/17.
 */
public class StackUsingLinkedListImpl {
    static Node head;
    static int size;
    public static void main(String args[]){
        LinkedList lst = new LinkedList();
        lst.push(10);
        lst.push(20);
        lst.push(40);
        lst.push(30);
        lst.push(40);
        lst.push(50);
        lst.push(60);
        System.out.println(lst.pop());
        System.out.println(lst.getSize());
        System.out.println(lst.pop());
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static class LinkedList{
        LinkedList(){
            head = null;
        }
        void push(int n){
            size++;
            Node oldHead = head;
            head = new Node(n);
            head.next = oldHead;
        }
        int pop(){
           if(head != null){
               size--;
               Node node = head;
               head = head.next;
               return node.data;
           }
           else return -1;
        }
        int peek(){
            return head.data;
        }
        int getSize(){
            return size;
        }
    }

}
