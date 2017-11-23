/**
 * Created by nimbekl on 9/1/17.
 */
import java.util.*;
/*
5 3
1 2 101 (1,2) -101 202 305 305 202
2 5 102 (2,3,4,5)
3 4 103 (3,4)
*/
public class arrayManipulation {
    public static void main(String args[]){
      Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long m = s.nextLong();
        long arr[] = new long[n];
        long max = 0;
        for(int i=0;i<m;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            long k = s.nextLong();
            arr[a-1]= arr[a-1]+k; // 100
            if(b<n) arr[b]= arr[b] - k;
        }
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> max) max=temp;
        }
        System.out.println(max);
    }
}
