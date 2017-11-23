package DsAndAlgo.Stack;

public class LengthLongestValidString {
    public static void main(String args[]){
        String str = "()(()))))"; //10
        System.out.println(new LengthLongestValidString().maxValidString(str));
    }
    int maxValidString(String str){
        int count = 0;
        Stack stack = new Stack();
        stack.push(-1);
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(!stack.isEmpty()){
                  int diff = i - stack.top.data;
                    if(count < diff){
                        count = diff;
                    }
                }else stack.push(i);
            }
        }
        return count;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    class Stack {
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
            if(top == null)return true;
            else return false;
        }
        int pop(){
            if(top == null)return -1;
            else{
                Node temp = top;
                top = top.next;
                return temp.data;
            }
        }
        int peek(){
            if(top == null)return -1;
            else return top.data;
        }
    }
}
