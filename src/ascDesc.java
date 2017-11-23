/**
 * Created by nimbekl on 10/12/17.
 */
import java.util.*;
public class ascDesc {
    public static void main(String args[]){
        //Scanner s = new Scanner(System.in);
        Integer[] arr = new Integer[]{3,6,5,8,6,10,6,34,76,7,1,5};
        Arrays.sort(arr, Collections.reverseOrder());
        int arrLength = arr.length-1;
        int half = arrLength/2;
        for(int i = 0;i<=half;i++){
            int j = arrLength-i;
            if(i !=j) {
            System.out.println(arr[i]);
            System.out.println(arr[arrLength - i]);
            }
        }
    }
}
