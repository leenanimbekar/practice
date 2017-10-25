/**
 * Created by nimbekl on 10/6/17.
 */
import java.util.*;
public class detectAndRemoveLoop {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
         data = d;
        }
    }
    public static void push(int data){
      Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    static int detectLoop(Node h){
        HashSet<Node> s = new HashSet<>();
        while(h!=null){
            if(s.contains(h)){
                return h.data;
            }
            else{
                s.add(h);
            }
            h = h.next;
        }
        return 0;
    }
    static int detectLoopByFloyedCycle(Node h){
        Node first = head,second = head;
        while(first != null && second !=null && second.next !=null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                return first.data;
            }
        }
      return 0;
    }
    public static void main(String args[]){
        detectAndRemoveLoop lst = new detectAndRemoveLoop();
        lst.push(20);
        lst.push(4);
        lst.push(15);
        lst.push(10);
        lst.head.next.next.next.next = lst.head;
        System.out.println(detectLoopByFloyedCycle(head));
    }
}
