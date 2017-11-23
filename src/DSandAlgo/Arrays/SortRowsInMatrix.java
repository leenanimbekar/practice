package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/10/17.
 */
import java.util.*;
public class SortRowsInMatrix {
    public static void main(String args[]) {
        int m = 4,n = 4;
        int arr[][] ={{40, 30, 20, 10},{15, 25, 35, 45},{27, 29, 37, 48},{32, 33, 39, 50}};
        for(int i = 0;i<m;i++){
            arr[i] = sortRow(arr[i]);
        }
    }
    static int[] sortRow(int[] row) {
        Arrays.sort(row);
        return row;
    }
}
