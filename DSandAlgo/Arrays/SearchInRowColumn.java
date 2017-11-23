package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/10/17.
 */
public class SearchInRowColumn {
    public static void main(String args[]) {
        int m = 4, n = 4;
        int arr[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int x = 52;
        int j = n-1;
        int i = 0;
        while(i < m && j<n){
            if(arr[i][j] == x){
                System.out.println(x+" Found at ("+i+","+j+")");
                return;
            }
            if(x < arr[i][j]){
                j--;
            }else i++;
        }
    }
}
