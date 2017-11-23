package WeekOfCode;

/**
 * Created by nimbekl on 11/14/17.
 */
import java.util.*;
public class TripleRecursion {

    static void tripleRecursion(int n, int m, int k) {
        int[][] arr = new int[n][n];
        int i = 0;
        int j = 0;
        arr[i][j] = m;

        while(i < n-1){
           i++;
           j++;
           arr[i][j] = arr[i-1][j-1]+k;
        }

        i = 1;
        while(i<n){
            j = 0;
              while(i>j){
                arr[i][j] = arr[i - 1][j] - 1;
                arr[j][i] = arr[i][j];
                j++;
            }
              i++;
        }
        for(int x = 0;x<n;x++){
            for(int y = 0;y<n;y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        tripleRecursion(n, m, k);
        s.close();
    }
}
