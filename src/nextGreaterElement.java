/**
 * Created by nimbekl on 11/2/17.
 */
public class nextGreaterElement {
    public static void main(String args[]){
        int arr[] = {11, 13, 21, 3};
        printNGE(arr);
    }
    static void printNGE(int [] arr){
        int i = 0;
        int elem,next;
        Stack s = new Stack();
        s.top = -1;
        s.push(arr[0]);
        for(int v = 1;v <arr.length;v++){
            next = arr[v];
            if(!s.isEmpty()){
               elem = s.pop();
                while(elem < next){
                    System.out.println(elem + " -- " + next);
                    if(s.isEmpty()){
                        break;
                    }
                    elem = s.pop();
                }
                if(elem>next){
                    s.push(elem);
                }
            }
            s.push(next);
        }
        while(!s.isEmpty()){
            elem = s.pop();
            next = -1;
            System.out.println(elem + " -- " + next);
        }
    }
    static class Stack{
        int top;
        int items[] = new int[100];
        void push(int n){
            if(top == 99){
               System.out.println("Stack full");
            }else{
                items[++top] = n;
            }
        }
        int pop(){
            if(top == -1){
                System.out.println("Stack Empty");
                return -1;
            }
            else{
                int elem = items[top];
                top-- ;
                return elem;
            }
        }
        boolean isEmpty(){
            return top == -1;
        }
    }
}
