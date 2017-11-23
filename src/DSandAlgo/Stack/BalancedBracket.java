package DsAndAlgo.Stack;

/**
 * Created by nimbekl on 11/21/17.
 */
import java.util.*;
public class BalancedBracket {
    String isBalanced(String s) {
     Stack stack = new Stack();
     int upper = 0;
     for(int i = 0;i<s.length();i++){
         if(!stack.isEmpty()){
             upper = stack.peek();
         }
         stack.push(s.charAt(i));
         if(upper == '(' && stack.peek() == ')' || upper == '[' && stack.peek()==']' || upper=='{' && stack.peek()=='}'){
            stack.pop();
            stack.pop();
         }
     }
     return stack.isEmpty()?"YES":"NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = new BalancedBracket().isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
    class Node {
       int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    class Stack{
        Node top;
        void push(int data){
            Node newNode = new Node(data);
            if(top == null){
                top = newNode;
            }else {
                newNode.next = top;
                top = newNode;
            }
        }

        int pop(){
          if(top == null)return -1;
            else {
              Node temp = top;
              top = top.next;
              return temp.data;
          }
        }

        boolean isEmpty(){
            return top==null;
        }

        int peek(){
            if(top == null)return -1;
            else return top.data;
        }
    }
}
