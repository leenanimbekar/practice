package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
import java.util.Arrays;
public class SumEqualToX {
    public static void main(String args[]){
        int[] arr = {-40, -5, 1, 3, 6, 7, 8, 20};
        int x = 15;
        Arrays.sort(arr);
        int sum = 0;
        int l = 0,r=arr.length-1;
        while(l<r){
           sum = arr[l]+arr[r];
            if(sum == x){
                System.out.println(arr[l]+" "+arr[r]);
                l++;
                r--;
            }else if(sum < x)l++;
            else r--;
        }
    }
}
