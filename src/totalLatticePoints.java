import java.util.Scanner;

/**
 * Created by nimbekl on 10/5/17.
 */
public class totalLatticePoints {
    public static void main(String args []){
        Scanner s = new Scanner(System.in);
        int radius = s.nextInt();
        if(radius == 0){
           System.out.println(1);
        }
        else {
            System.out.println(countLattice(radius));
        }
    }

    private static int countLattice(int r){
        int totalLattice = 4;
        int sqrR = r*r;
        for(int x = 1;x<r;x++){
            int ySqr = sqrR - (x*x);
            int y = (int)Math.sqrt(ySqr);
            if(y*y == ySqr){
                totalLattice += 4;
            }
        }
        return totalLattice;
    }

}
