/**
 * Created by nimbekl on 10/23/17.
 */
public class stack {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    class myStack {
        Node head;
        Node mid;
        int count;
    }
    myStack createStack(){
        myStack newStack = new myStack();
        newStack.count = 0;
        return newStack;
    }
    void push(myStack currentStack , int n){
        Node node = new Node(n);
        node.prev = null;
        node.next = currentStack.head;
        currentStack.count++;
        if(currentStack.count == 1){
            currentStack.mid = node;
        }else {
            currentStack.head.prev = node;
            if(currentStack.count % 2 != 0){
                currentStack.mid = currentStack.mid.prev;
            }
        }
        currentStack.head = node;
    }
    int pop(myStack currentStack){
        if(currentStack.count==0){
            System.out.print("Stack is Empty");
           return -1;
        }
        Node node = currentStack.head;
        currentStack.head = node.next;
        if(currentStack.head!=null) {
            currentStack.head.prev = null;
        }
        currentStack.count--;
        if(currentStack.count%2==0){
            currentStack.mid = currentStack.mid.next;
        }
        return node.data;
    }
    int findMiddle(myStack currentStack){
        if(currentStack.count == 0){
            System.out.print("Stack is Empty");
            return -1;
        }
        return currentStack.mid.data;
    }
    public static void main(String args[]){
        stack stc = new stack();
        myStack createstack = stc.createStack();
        stc.push(createstack,11);
        stc.push(createstack,22);
        stc.push(createstack,33);
        stc.push(createstack,44);
        stc.push(createstack,55);
        stc.push(createstack,66);
        stc.push(createstack,77);
        System.out.println("Item popped is " + stc.pop(createstack));
        System.out.println("Item popped is " + stc.pop(createstack));
        System.out.println("Middle Element is " + stc.findMiddle(createstack));
    }
}

