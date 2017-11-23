/**
 * Created by nimbekl on 11/2/17.
 */
public class bubbleSort {
    public static void main(String args[]){
        int [] arr = {64, 34, 25, 12, 22, 11, 90};
        int length = arr.length;
        for(int i = 0;i<length-1;i++){
            for(int j = 0;j<length-i-1;j++){
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int k=0; k<length; ++k) System.out.print(arr[k] + " ");
    }
}
