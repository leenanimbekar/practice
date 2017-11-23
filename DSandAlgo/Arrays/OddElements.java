package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class OddElements {
    public static void main(String args[]){
        int arr[] = {20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        int result = 0;
        for(int i =0;i<arr.length;i++){
            result = result ^ arr[i];
        }
        System.out.print(result);
    }
}
