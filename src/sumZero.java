/**
 * Created by nimbekl on 10/17/17.
 */
import java.util.*;
public class sumZero {
    public static void main(String args[]){
        int[] arr = {2,3,4,1,-6,4,1}; // -6,-4,-3,1,1,2,4
        Arrays.sort(arr);
        int size = arr.length;
        int i= 0,j = 1;
        while(i < size && j < size){
            if(i != j && (arr[i] + arr[j]== 0)){
                System.out.println("true" + '(' +arr[i] +','+ arr[j]+')');
                return ;
            }
            else if(arr[i] + arr[j] < 0){
                i++;
            }
            else j++;
        }
        System.out.println("false");
    }
}
