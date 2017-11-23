package DsAndAlgo.LinkedList;

/**
 * Created by nimbekl on 11/5/17.
 */
public class SinglyLinkedListImpl {
    public static void main(String args[]){
        LinkedListSingly s = new LinkedListSingly();
        /*s.add(1);
        s.add(2);
        s.add(3);
        s.print();
        s.addAfter(4,2);
        s.print();
        s.addFirst(5);
        s.print();
        System.out.println(s.getMiddle());*/
        s.add(1);
        s.add(2);
        s.add(1);
        System.out.println(s.isPalindrom());
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static class LinkedListSingly{
        Node head;
        int size;
        Node current;
        LinkedListSingly(){
            head = null;
            current = null;
        }
        boolean isPalindrom(){
            int pos = 1;
            int end = size;
            boolean b = false;
            while(pos < end && pos != end){
              if(getElemByPos(pos) == getElemByPos(end)){
                b = true;
              }
              else {
                  b = false;
                  break;
              }
              pos++;
              end--;
            }
            return b;
        }
        int getMiddle(){
            return getElemByPos((size+1)/2);
        }
        int getElemByPos(int pos){
            Node node = head;
            int currentPosition = 1;
            Node result;
          while(node != null){
            if(pos == currentPosition){
                result = node;
                break;
            }
              currentPosition++;
              node = node.next;
            }
            return node.data;
        }
        void add(int n){
            Node node = new Node(n);
            size++;
            if(head == null){
                head = node;
                current = head;
            }
            else {
                current.next = node;
                current = node;
            }
        }
        void addFirst(int n){
          Node node = new Node(n);
            size++;
          if(head == null){
             head = node;
          }else{
              node.next = head;
              head = node;
          }
        }
        void addAfter(int n,int after){
            Node node = new Node(n);
                Node current = head;
                while(current != null){
                    if(current.data == after){
                        Node tempNode = current.next;
                        current.next = node;
                        node.next = tempNode;
                        size++;
                    }
                    current = current.next;

            }
        }
        void deleteLast(Node node){
            Node current = node;
            if(node!=null && node.next!=null && node.next.next == null){
                node.next = null;
                size--;
            }else deleteLast(node.next);
        }
        void deleteFirst(){
            head = head.next;
            size--;
        }
        void delete(int n){
            Node current = head;
            while(current != null && current.next!=null){
                if(current.next.data == n){
                   current.next = current.next.next;
                    size--;
                }
                current= current.next;
            }
        }
        void print(){
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
          }
            System.out.println();
        }
    }
}
