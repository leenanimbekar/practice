/**
 * Created by nimbekl on 10/6/17.
 */
public class pefectRobbery {
    public static void main(String args[]){
        int [] arr = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(maxLoot(arr,arr.length));
    }

    public static int maxLoot(int [] arr,int n){
        if(n == 0){
            return 0;
        }
        int first = arr[0];
        if(n == 1){
            return first;
        }
        int second = arr[1];
        if(n ==2){
            return Math.max(first,second);
        }
        int dp[] =new int[n];
        dp[0] = first;
        dp[1] = second;
        int max_val = 0;

        for(int i =2;i<n;i++){
            max_val = Math.max(arr[i]+first,second);
            first = second;
            second = max_val;
        }
        return max_val;
    }

}
