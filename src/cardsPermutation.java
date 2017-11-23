/**
 * Created by nimbekl on 10/30/17.
 */
import java.util.*;
public class cardsPermutation {
    static int sum = 0;

    static void count() {
        sum++;
    }
    ;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] arr = new int[num];
        int[] resultArr = new int[num];
        for (int a = 0; a < num; a++) {
            arr[a] = a + 1;
            resultArr[a] = s.nextInt();
        }
        int index = 0;
        permute(arr, index, resultArr);
    }

    static void permute(int[] arr, int index, int[] resultArr) {
        boolean val = false;
        if (index >= arr.length - 1) {
            count();
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                /*if(resultArr[i] != 0) {
                    if (arr[i] == resultArr[i]) {
                        val = true;
                    } else {
                        val = false;
                        break;
                    }
                }*/
        }
        System.out.println("");
        if (val) {
            //System.out.println(sum);
        }
        return;
    }
        for(int i = index;i<arr.length;i++){
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
            permute(arr,index+1,resultArr);
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }
}

