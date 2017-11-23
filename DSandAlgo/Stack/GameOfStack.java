package DsAndAlgo.Stack;

/**
 * Created by nimbekl on 11/21/17.
 */
import java.util.Scanner;
public class GameOfStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }
            Stack A = new Stack();
            for (int a_i = n-1; a_i >= 0; a_i--) {
                    A.push(a[a_i]);
            }
            int[] b = new int[m];
            for (int b_i = 0; b_i < m; b_i++) {
                b[b_i] = in.nextInt();
            }
            Stack B = new Stack();
            for (int b_i = m-1; b_i >= 0; b_i--) {
                    B.push(b[b_i]);
            }
            System.out.println(getCount(A,B,x));
        }
    }
    static int getCount(Stack A,Stack B,int x){
        int count = 0;
        int total = 0;
        Stack tempA = new Stack();
        Stack tempB = new Stack();
        while(!A.isEmpty() && A.peek()+total <= x){
            total += A.peek();
            tempA.push(A.pop());
            count++;
        }
        int countA = count;
        int countB = 0;
        while(!B.isEmpty()) {
            total += B.peek();
            tempB.push(B.pop());
            countB++;
            while (total > x && !tempA.isEmpty()) {
                total -= tempA.peek();
                A.push(tempA.pop());
                countA--;
            }
            if (total <= x && count < countA + countB) {
                count = countA + countB;
            }
        }
        return count;
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static class Stack{
        Node top;
        void push(int n){
          Node newNode = new Node(n);
          if(top == null){
              top = newNode;
          }else{
              newNode.next = top;
              top = newNode;
          }
        }

        boolean isEmpty(){
            return top == null;
        }

        int pop(){
            if (top==null)return -1;
            else {
                Node temp = top;
                top = top.next;
                return temp.data;
            }
        }

        int peek(){
            if (top==null)return -1;
            else return top.data;
        }
    }
}
