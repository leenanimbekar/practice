package DSandAlgo.Queue;

/**
 * Created by nimbekl on 11/23/17.
 */
import java.util.Scanner;
public class QueueWithTwoStack {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        for(int i = 0;i<total;i++){
            int operation = s.nextInt();
            if(operation == 1){
                stack1.push(s.nextInt());
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if(operation == 2){
                stack2.pop();
            }
            if(operation == 3){
                System.out.println(stack2.peek());
            }
        }
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static class Stack{
       Node head;
        void push(int n){
            Node newNode = new Node(n);
            if(head == null) head = newNode;
            else {
                newNode.next = head;
                head = newNode;
            }
        }
        int pop(){
           if(head == null)return -1;
            else {
               Node temp = head;
               head = temp.next;
               return temp.data;
           }
        }

        int peek(){
            if(head == null)return -1;
            else return head.data;
        }

        boolean isEmpty(){
            return head==null;
        }
    }
}
