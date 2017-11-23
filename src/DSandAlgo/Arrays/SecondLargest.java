package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class SecondLargest {
    public static void main(String args[]){
        int[] arr = {7,5,6,1,4,2};
        /*int highest = -1;
        int secondHigh = -1;*/
        int min = arr[0];
        int secondMin = arr[0];
        for(int i =0;i<arr.length;i++){
            if(min>arr[i]){
               //secondHigh = highest;
                secondMin = min;
               //highest = arr[i];
                min = arr[i];
            }else if(secondMin>arr[i]){
                secondMin = arr[i];
            }
        }
        System.out.println(secondMin);
    }
}
