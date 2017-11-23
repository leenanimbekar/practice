package DsAndAlgo.LinkedList;

/**
 * Created by nimbekl on 11/6/17.
 */
public class ReverseInPair {
    public static void main(String args[]){
        SinglyLinkedListImpl.LinkedListSingly s = new SinglyLinkedListImpl.LinkedListSingly();
        s.add(1);
        s.add(2);
        s.add(3);
        printReverseInPair(s.head);
    }
    static void printReverseInPair(SinglyLinkedListImpl.Node head){
        SinglyLinkedListImpl.Node current = head;
        SinglyLinkedListImpl.Node temp = null;
        SinglyLinkedListImpl.Node newHead = null;
        while(current != null && current.next != null){
            if(temp !=  null){
                temp.next.next = current.next;
            }
            temp = current.next;
            current.next = temp.next;
            temp.next = current;
            if(newHead == null){
                newHead = temp;
                current = current.next;
            }
        }
        while(newHead != null){
           System.out.print(newHead.data);
            newHead= newHead.next;
        }
    }
}
