package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class MissingNumbers {
    public static void main(String args[]){
        int[] arr = {5,3,1,2};
        int max=0;
        int sum=0;
        for(int i = 0 ;i<arr.length;i++){
           if(max<arr[i]){
             max = arr[i];
           }
           sum = sum +arr[i];
        }
        int total = (max*(max+1))/2;
        System.out.println(total-sum);
    }
}
