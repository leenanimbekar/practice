package DsAndAlgo;

/**
 * Created by nimbekl on 11/5/17.
 */
public class SortStackUsingStack {
    int arr[];
    int top;
    int size;

    SortStackUsingStack(int size) {
        arr = new int[size+1];
        top = -1;
        this.size = size;
    }
    public static void main(String args[]){
        SortStackUsingStack s = new SortStackUsingStack(10);
        s.push(42);
        s.push(7);
        s.push(1);
        s.push(3);
        s.printStack();
        SortStackUsingStack s2 = sort(s);
        s2.printStack();
    }
    static SortStackUsingStack sort(SortStackUsingStack s) {
        SortStackUsingStack tempStack = new SortStackUsingStack(10);
        while (!s.isEmpty()) {
            int current = s.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                s.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        return tempStack;
    }
        void push(int n) {
            if (!isFull()) {
                top++;
                arr[top] = n;
            }
        }

        int pop() {
            if (!isEmpty()) {
                int data = arr[top];
                top--;
                return data;
            } else return -1;
        }

        int peek() {
            return arr[top];
        }

        boolean isFull() {
            return size - top < 0;
        }

        boolean isEmpty() {
            return top == -1;
        }

        public void printStack() {
            if (top >= 0) {
                System.out.println("Elements of stacks are:");
                for (int i = 0; i <= top; i++) {
                    System.out.println(arr[i]);
                }
            }
        }
}
