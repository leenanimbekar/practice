import java.util.Scanner;
/**
 * Created by nimbekl on 1/23/17.
 */
public class quickSort {
    public static void main(String args[]){
        int [] arr = {10, 80, 30, 90, 40, 50, 70};
        sort(arr,0,arr.length-1);
        for (int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
    }
    static void sort(int [] arr,int low,int high){
        if(low<high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }
    static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int j = low-1;
        for(int i = low ;i<high;i++){
           if(arr[i]<=pivot){
            j++;
            int temp = arr[j];
               arr[j] = arr[i];
               arr[i] = temp;
           }
        }
        int temp = arr[j+1];
        arr[j+1]= arr[high];
        arr[high] = temp;
        return j+1;
    }
}
