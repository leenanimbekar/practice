/**
 * Created by nimbekl on 4/4/17.
 */
import java.util.*;
public class updateArrayToMin {
    public static void main(String args[]){
      Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int max = 0;
    int arr[] = new int[n];
        for (int i=0; i<n; i++){
        arr[i] = in.nextInt();
        max = arr[i]>max?arr[i]-1:max;
        }
        System.out.println(max);
    }
}
