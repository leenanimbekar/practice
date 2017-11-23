import java.util.Arrays;

/**
 * Created by nimbekl on 10/23/17.
 */
public class coinChange {
    public static void main(String args[]){
        int[] arr = {2, 5, 3, 6};
        Arrays.sort(arr);
        int n = 10;
        System.out.println(optimalSolution(arr,arr.length,n));
    }
    static int getTotalSolutions(int[] arr,int m,int n){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(m<=0 && n>=1){
            return 0;
        }
        return getTotalSolutions(arr,m-1,n)+getTotalSolutions(arr,m,n-arr[m-1]);
    }

    static long optimalSolution(int[] arr,int m,int n){
       long table[] = new long[n+1];
        Arrays.fill(table,0);
        table[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = arr[i]; j<=n; j++){
                table[j] += table[j-arr[i]];
            }
        }
        return table[n];
    }
}
