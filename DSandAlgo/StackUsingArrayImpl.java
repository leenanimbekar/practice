package DsAndAlgo;

/**
 * Created by nimbekl on 11/5/17.
 */
public class StackUsingArrayImpl {
    static int size;
    static int arr[];
    static int top;
    public static void main(String args[]){
        stack s = new stack(10);
        s.push(10);
        s.push(20);
        s.push(40);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        s.push(80);
        s.push(90);
        s.push(100);
        s.push(110);
    }
    static class stack{
        int size;
        stack(int size){
          arr = new int[size+1];
          top = -1;
          this.size = size;
        }
        void push(int n){
            if(!isFull() && top <size){
              top++;
              arr[top] = n;
            }else {
                System.out.println("Stack Full !");
            }
        }
        int pop(){
            if(!isEmpty()){
                int n = arr[top];
                top--;
                return n;
            }else {
                System.out.println("Stack Empty !");
                return -1;
            }
        }
        int peek(){
            if(!isEmpty()) {
                return arr[top];
            }
            else {
                System.out.println("Stack Empty !");
                return -1;
            }
        }
        boolean isFull(){
           return size-top < 0;
        }
        boolean isEmpty(){
            return top == -1;
        }
    }
}
