/**
 * Created by nimbekl on 11/2/17.
 */
public class kStack {
    int arr[];
    static int top[];
    int next[];
    int n , k;
    static int free;
    kStack(int k1,int n1){
        k = k1;
        n = n1;
        arr = new int[n];
        top = new int[k];
        next = new int[n];
        for(int i = 0;i <k;i++){
            top[i] = -1;
        }
        free = 0;
        for(int i = 0 ;i <n-1;i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
    }
    static boolean isFull(){
        return free==-1;
    }
    static boolean isEmpty(int sn){
        return top[sn]==-1;
    }
    void push(int item,int sn){
        if(isFull()){
            System.out.println("OverFlow");
            return;
        }
        int i = free;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = item;
    }
    int pop(int sn){
        if(isEmpty(sn)){
            System.out.println("UnderFlow");
            return Integer.MAX_VALUE;
        }
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }
    public static void main(String args[]){
        int k = 3;int n =10;

    }
}
