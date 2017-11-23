package DsAndAlgo.LinkedList;

/**
 * Created by nimbekl on 11/5/17.
 */
public class ReverseLinkedList {
    public static void main(String args[]){
        SinglyLinkedListImpl.LinkedListSingly s = new SinglyLinkedListImpl.LinkedListSingly();
        s.add(1);
        s.add(2);
        s.add(3);
        printReverse(s.head);
    }
    static void printReverse(SinglyLinkedListImpl.Node currentNode){
        SinglyLinkedListImpl.Node prevNode = null;
        SinglyLinkedListImpl.Node next;
        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = next;
        }
        while(prevNode != null){
            System.out.print(prevNode.data+" ");
            prevNode = prevNode.next;
        }
    }
}
