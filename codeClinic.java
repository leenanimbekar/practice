/**
 * Created by nimbekl on 10/10/17.
 */
import java.util.*;
public class codeClinic {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(fnumber(k,arr));
    }
     static int fnumber(long input1, int[] input2){
         Integer[] integerLst = new Integer[input2.length];
         int z = 0;
         for (int value : input2) {
             integerLst[z++] = Integer.valueOf(value);
         }
             for(int i = 1 ;i<=input2.length;i++){
                 if(kLargest(integerLst,i) > input1){
                     return i;
                 };
             }
         return -1;
    }
    static int kLargest(Integer [] arr, int k) {
        Integer[]  maxArray = new Integer[k] ;
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < k; i++){
            maxArray[i] = arr[i];
        }
        return sum(maxArray);
    }

    static int sum(Integer[] arr) {
        int sum = 0;
        int i;

        for (i = 0; i < arr.length; i++)
            sum +=  arr[i];

        return sum;
    }
}
