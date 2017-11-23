package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/8/17.
 */
import java.util.*;
public class LongestRepeatingSubsequenceInSingleString {
    public static void main(String args[]){
        getSubsequence("AABEBCDD");
    }
    static void getSubsequence(String str){
      char[] charArr = str.toCharArray();
      int n = str.length();
        int L[][] = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i ==0|| j==0){
                    L[i][j] = 0;
                }else if(charArr[i-1]==charArr[j-1] && i!=j){
                    L[i][j] = L[i-1][j-1]+1;
                }else{
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }
      int i = n,j=n;
      String res = "";
      while(i>0&&j>0){
        if(L[i][j] == L[i-1][j-1]+1){
            res = res+charArr[i-1];
            i--;j--;
        }else if(L[i][j]==L[i-1][j]){
            i--;
        }else j--;
      }
      System.out.print(res);
    }
}
