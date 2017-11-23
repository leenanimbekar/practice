package WeekOfCode;

/**
 * Created by nimbekl on 11/15/17.
 */
import java.util.*;
public class SurfaceArea3D {
    static int surfaceArea(int[][] A,int row,int col) {
        int count = 0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++) {
                int currentVal = A[i][j];
                int upper = 0;//i-i
                int lower = 0;//i+1
                int left = 0;//j-1
                int right = 0;//j+1

                if(i - 1 >= 0){
                    if(currentVal- A[i-1][j] > 0){
                        upper = currentVal- A[i-1][j];
                    }
                }else{
                    upper = currentVal;
                }

                if(i + 1 <= row-1){
                    if(currentVal- A[i+1][j] > 0){
                        lower = currentVal - A[i+1][j];
                    }
                }else{
                    lower = currentVal;
                }
                if(j - 1 >= 0){
                    if(currentVal- A[i][j-1] > 0){
                        left = currentVal- A[i][j-1];
                    }
                }else{
                    left = currentVal;
                }
                if(j + 1 <= col-1){
                    if(currentVal- A[i][j+1] > 0){
                        right = currentVal- A[i][j+1];
                    }
                }else{
                    right = currentVal;
                }
                count += upper + lower + left + right + 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int W = in.nextInt();
        int[][] A = new int[H][W];
        for(int A_i = 0; A_i < H; A_i++){
            for(int A_j = 0; A_j < W; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = surfaceArea(A,H,W);
        System.out.println(result);
        in.close();
    }
}
