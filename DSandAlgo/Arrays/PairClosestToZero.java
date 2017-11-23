package DsAndAlgo.Array;

import java.util.Arrays;

/**
 * Created by nimbekl on 11/7/17.
 */
public class PairClosestToZero {
    public static void main(String args[]){
        int[] arr = {1,3,-5,7,8,20,-40,6};
        Arrays.sort(arr);
        int sum = 0;
        int minSum=Integer.MAX_VALUE;
        int l = 0;
        int r = arr.length-1;
        int minLeft = l,minRight = r;
        while(l<r){
            sum = arr[l]+arr[r];
            if(Math.abs(sum)<Math.abs(minSum)){
                minSum = sum;
                minLeft = l;
                minRight = r;
            }
            if(sum < 0){
                l++;
            }else r--;
        }
        System.out.println(arr[minLeft]+" "+arr[minRight]);
    }
}
