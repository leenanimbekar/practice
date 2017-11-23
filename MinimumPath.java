/**
 * Created by nimbekl on 11/15/17.
 */
import javax.jnlp.IntegrationService;
import java.util.*;
public class MinimumPath {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int arr[][] = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int totalCases = in.nextInt();
        int[][] queries = new int[totalCases][4];
        for(int i = 0;i<totalCases;i++){
            for(int j = 0;j<4;j++){
                queries[i][j] = in.nextInt();
            }
        }
    }
    int totalPathCount(int[][]arr,int srcRow,int srcCol,int destRow,int destCol){
      Stack<Integer> s = new Stack();
        int count = 0;
        for(int i = srcRow;i<arr.length;i++){
            for(int j = srcCol;j<arr[0].length;j++) {
                int right = arr[srcRow][srcCol+1];
                int bottom = arr[srcRow+1][srcCol];
                if(right>bottom){
                    s.push(bottom);
                }else s.push(right);
                while(!s.isEmpty()){
                   int current = s.pop();

                }
            }
        }
        return count;
    }
}
