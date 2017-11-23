package DsAndAlgo.Stack;

/**
 * Created by nimbekl on 11/22/17.
 */
import java.util.Scanner;
import java.util.TreeMap;
public class Waiter {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] number = new int[n];
        Stack A0 = new Stack();
        for(int number_i = 0; number_i < n; number_i++){
            number[number_i] = in.nextInt();

        }
        for(int number_i = number.length-1; number_i >=0; number_i--){
            A0.push(number[number_i]);
        }
        Stack stacksA[] = new Stack[q+1];
        stacksA[0] = A0;
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i = 1;i<=q;i++) {
            Stack curr = stacksA[i - 1];
            Stack A = new Stack();
            int x = 0;
            while (curr != null && !curr.isEmpty()) {
                int num = curr.pop();
                if(num == x) {
                    System.out.println(num);
                    continue;
                }
                if(num == A.peek()){
                   A.push(num);
                   continue;
                }
                int prime = 0;
                if(mp.containsKey(i)) {
                    prime = mp.get(i);
                }else {
                    prime = getNthPrime(i);
                    mp.put(i,prime);
                }
                if (num % prime == 0) {
                    x = num;
                    System.out.println(num);
                } else {
                    A.push(num);
                }
            }
            if (!A.isEmpty()) {
                stacksA[i] = A;
            }
        }
        Stack resultA = new Stack();
        while(stacksA[q]!= null && !stacksA[q].isEmpty()){
            resultA.push(stacksA[q].pop());
        }
        while(!resultA.isEmpty()){
            System.out.println(resultA.pop());
        }
    }
    static int getNthPrime(int n){
        if (n < 2) return 2;
        if (n == 2) return 3;
        if (n == 3) return 5;
        n -= 2;
        int[] primes = new int[n];
        primes[0] = 5;
        int candidate, count, step = 2;
        for(candidate = 7, count = 1; count < n; step = 6-step, candidate += step) {
            if (isPrime(candidate,primes,count)) {
                primes[count] = candidate;
                ++count;
            }
        }
        return primes[n-1];
    }
    static boolean isPrime(int n, int[] primes, int primeCount) {
        int m = (int)Math.sqrt(n) + 1;
        for(int i = 0, p; i < primeCount && (p = primes[i]) < m; ++i) {
            if (n % p == 0) {
                return false;
            }
        }
        return true;
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
            }else {
                newNode.next = top;
                top = newNode;
            }
        }

        boolean getNode(int n){
            Node node = top;
           while(node != null){
             if(node.data == n){
                return true;
             }else node = node.next;
           }
           return false;
        }

        int pop(){
            if (top == null)return -1;
            else {
                Node temp = top;
                top = top.next;
                return temp.data;
            }
        }

        boolean isEmpty(){
            return top == null;
        }

        int peek(){
            if(top == null)return -1;
            else return top.data;
        }
    }
}
