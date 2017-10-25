/**
 * Created by nimbekl on 10/23/17.
 */
import java.util.*;
public class shuffleArray {
    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Random rnd = new Random();
        rnd.nextInt();
        for(int i = 0 ;i <arr.length;i++){
            int x = i + rnd.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
