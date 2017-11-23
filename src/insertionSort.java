/**
 * Created by nimbekl on 11/2/17.
 */
public class insertionSort {
    public static void main(String args[]){
        int [] arr = {12, 11, 13, 5, 6};
        int len = arr.length;
        for(int i = 0;i<len;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        for (int k=0; k<len; ++k) System.out.print(arr[k] + " ");
    }
}
