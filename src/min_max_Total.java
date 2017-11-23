/**
 * Created by nimbekl on 6/13/17.
 */
import java.util.*;
public class min_max_Total {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextLong();
        }
        Arrays.sort(arr);
        System.out.println(arr[0]+arr[1]+arr[2]+arr[3]);
        System.out.println(arr[1]+arr[2]+arr[3]+arr[4]);
    }
}
