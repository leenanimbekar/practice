package DsAndAlgo.LinkedList;
public class DetectLoop {

    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    Node hasLoop(){
        Node first = head;
        Node second = head;
        Node result = null;
        while(second != null && second.next != null){
          first = first.next;
          second = second.next.next;
          if(first == second){
              System.out.println("true");
              result = second;
              break;
          }
        }
        return result;
    }
    void getStartNodeLoop(Node meetingPoint){
            Node first = meetingPoint;
            Node second = head;
            while(second !=null && second.next != null){
                first = first.next;
                second = second.next;
                if(first == second){
                    System.out.println(first.value);
                    break;
                }
            }
    }

    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        Node loopNode = new Node(7);
        list.addToTheLast(new Node(5));
        list.addToTheLast(new Node(6));
        list.addToTheLast(loopNode);
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList();
        list.addToTheLast(loopNode);
        Node meetingPoint = list.hasLoop();
        list.getStartNodeLoop(meetingPoint);
    }
}