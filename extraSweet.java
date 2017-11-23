/**
 * Created by nimbekl on 10/28/17.
 */
import java.util.*;
public class extraSweet {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long s = in.nextLong();
        ArrayList<Long> lst = new ArrayList<Long>();
        chocolate choco = new chocolate();
        for(long i = 0; i<n;i ++){
            choco.addPiece(i);
        }
        for(long a0 = 0; a0 < s; a0++) {
            long l = in.nextLong();
            long r = in.nextLong();
            long sweetness = 0;
            if(l>0) {
                long prev = choco.getPiece(l).prev.data;
                sweetness = sweetness + prev;
                choco.removePiece(prev);
            }
            if(r<n-1) {
                long after = choco.getPiece(r).next.data;
                sweetness = sweetness + after;
                choco.removePiece(after);
            }
                for (long b0 = l; b0 >= 0 && b0 <= r && b0 <= n; b0++) {
                    sweetness = sweetness + choco.getPiece(b0).data;
                    choco.removePiece(b0);
                }
            lst.add(sweetness);
        }
        Iterator it = lst.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        in.close();
    }
}
class chocolate extends extraSweet{

    chocolatePiece head;
    chocolatePiece last;
    long i = 0;
    public void addPiece(long n){
        if(head == null){
            chocolatePiece p = new chocolatePiece(n);
            head = p;
            last = p;
        }else last = addPieceAfter(last,n);
    }

    public chocolatePiece addPieceAfter(chocolatePiece prevNode,long n){
        chocolatePiece p = new chocolatePiece(n);
        prevNode.next = p;
        p.prev = prevNode;
        return p;
    }

    public chocolatePiece getPiece(long n){
        if(head == null) {
            return null;
        }
            chocolatePiece current = head;
            while(current != null) {
                if (current.data == n) {
                    return current;
                }
                current = current.next;
            }
            return current;
        }

    public void removePiece(long n){
        if(head == null){
            return;
        }
        chocolatePiece current = head;
        current = getPiece(n);
        if (current == null)
            return;
        if(current == head && current.data ==0){
            head = current.next;
            return;
        }
        deleteNode(head, current);
    }

    public void deleteNode(chocolatePiece head, chocolatePiece delNode){
        if(head == null){
            return;
        }
        if(delNode.next !=null){
            delNode.next.prev = delNode.prev;
        }
        if(delNode.prev != null){
            delNode.prev.next = delNode.next;
        }
    }


    class chocolatePiece {
        long data;
        chocolatePiece prev;
        chocolatePiece next;

        chocolatePiece(long data) {
            this.data = data;
        }
    }
}
