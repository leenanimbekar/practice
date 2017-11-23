package DsAndAlgo.Array;

import java.util.ArrayList;

/**
 * Created by nimbekl on 11/7/17.
 */
import java.util.Arrays;
public class SumClosestToX {
    public static void main(String args[]){
        int[] arr = {-40,-5,1,3,6,7,8,20};
        Arrays.sort(arr);
        int x = 5;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int l = 0,r=arr.length-1;
        int minLeft = l,minRight = r;
        while(l<r){
         sum = arr[l]+arr[r]-x;
            if(Math.abs(sum)<Math.abs(minSum)){
                minSum =  sum;
                minLeft = l;
                minRight = r;
            }
            if(sum + x < 0){
              l++;
            }else r--;
        }
        System.out.println(arr[minLeft]+" "+arr[minRight]);
    }
}
