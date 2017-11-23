package DsAndAlgo;

/**
 * Created by nimbekl on 11/5/17.
 */
//Queue - FIFO
public class StackUsingTwoQImpl {
    public static void main(String args[]){
        Queue q1 = new Queue();
        q1.push(10);
        q1.push(20);
        q1.push(40);
        q1.push(30);
        q1.push(40);
        q1.push(50);
        q1.push(60);
        Queue q2 = new Queue();
        for(int i = 0;i<q1.size;i++){
            q2.push(q1.deQueue());
        }
        q1 = q2;
        System.out.println(q1.pop());
        System.out.println(q1.pop());
    }
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
          this.data = data;
        }
    }
    static class Queue{
        Node first;
        Node current;
        int size;
        Queue(){
            first = null;
            current = null;
            size =0;
        }
        void push(int n){
            Node node = new Node(n);
            size++;
            if(first == null){
                first = node;
                current = first;
            }else {
                current.next = node;
                node.prev = current;
                current = node;

            }
        }
        int pop(){
           if(first != null){
             size--;
             Node node = first;
               first = first.next;
               return node.data;
           }else {
               return -1;
           }
        }
        int deQueue(){
            if(current != null){
               size--;
                Node node = current;
                current = current.prev;
                return node.data;
            }else return -1;
        }
    }
}
