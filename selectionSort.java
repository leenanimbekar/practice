/**
 * Created by nimbekl on 11/2/17.
 */
public class selectionSort {
    public static void main(String args[]){
        int [] arr = {64,25,12,22,11};
        sort(arr);
        for (int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
    }
    static void sort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx]) min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
