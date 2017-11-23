package WeekOfCode;

/**
 * Created by nimbekl on 11/16/17.
 */
import java.util.*;
public class MatrixLand {
    static int maxValue(int[][] mat) {
        int M = mat.length,N = mat[0].length;
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry1:mp.entrySet()){
            ArrayList<Integer> lst = entry1.getValue();
        }
        final int length = mat.length;
        final int[][][] sumArr = new int[3][M][N];
        for (int row = M - 1; row >= 0; row--) {
            for (int col = 0; col < N; col++) {
                int val = mat[row][col];
                int val2 = mat[row][col] * 2;
                if (row == M - 1 && col == 0) {
                    sumArr[0][row][col] = val;
                    sumArr[1][row][col] = val2;
                } else if (row == M - 1) {
                    sumArr[0][row][col] = sumArr[0][row][col - 1] + val;
                    sumArr[1][row][col] = Math.max(
                            sumArr[1][row][col - 1] + val
                            ,   sumArr[0][row][col - 1] + val2
                    );
                    sumArr[2][row][col] = Math.max(
                            sumArr[1][row][col - 1] + val2
                            ,   sumArr[2][row][col - 1] + val
                    );
                } else if (col == 0) {
                    sumArr[0][row][col] = sumArr[0][row + 1][col] + val;
                    sumArr[1][row][col] = Math.max(
                            sumArr[0][row + 1][col] + val2
                            ,   sumArr[1][row + 1][col] + val
                    );
                    sumArr[2][row][col] = Math.max(
                            sumArr[1][row + 1][col] + val2
                            ,   sumArr[2][row + 1][col] + val
                    );
                } else {
                    sumArr[0][row][col] = Math.max(
                            sumArr[0][row][col - 1], sumArr[0][row + 1][col]
                    ) + mat[row][col];
                    sumArr[1][row][col] = Math.max(
                            Math.max(sumArr[0][row][col - 1], sumArr[0][row + 1][col]) + val2
                            ,   Math.max(sumArr[1][row][col - 1], sumArr[1][row + 1][col]) + val
                    );
                    sumArr[2][row][col] = Math.max(
                            Math.max(sumArr[1][row][col - 1], sumArr[1][row + 1][col])+val2
                            ,   Math.max(sumArr[2][row][col - 1], sumArr[2][row + 1][col])+val
                    );
                }
            }
        }
        return sumArr[2][0][length - 1];
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];
        try {
            for (int A_i = 0; A_i < n; A_i++) {
                for (int A_j = 0; A_j < m; A_j++) {
                    A[A_i][A_j] = in.nextInt();
                }
            }
        }catch( IndexOutOfBoundsException e){

        }catch ( Exception e){

        }
        int result = maxValue(A);
        System.out.println(result);
        in.close();
    }
}
/*
5 5
100 -10 -10 -100 -250
200 -10 -10 -10 -200
10 -10 -200 -10 -10
10 10 -200 -10 200
-10 -10 -200 -10 200

650*/
