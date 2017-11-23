/**
 * Created by nimbekl on 11/5/17.
 */
import java.util.*;

public class QueenAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long k = in.nextInt();
        long rQueen = in.nextInt();
        long cQueen = in.nextInt();
        long total = 5*n - 2*rQueen-3;
        for(int a0 = 0; a0 < k; a0++) {
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            if (rQueen == rObstacle || cQueen == cObstacle || Math.abs(rQueen - rObstacle) == Math.abs(cQueen - cObstacle)) {
                if (cQueen > cObstacle) {
                    total = total - cObstacle;
                } else if (cQueen < cObstacle) {
                    total = total - (n - cObstacle + 1);
                } else if (rQueen > rObstacle) {
                    total = total - rObstacle;
                } else if (rQueen < rObstacle) {
                    total = total - (n - rObstacle + 1);
                }
            }
        }
        System.out.println(total);
    }
}
