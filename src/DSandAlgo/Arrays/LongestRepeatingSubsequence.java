package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class LongestRepeatingSubsequence {
    public static void main(String args[]){
        String s1 = "AABEBCDD";
        String s2 = "AABEBCDD";
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        optimalLCS(s1,s2,char1.length,char2.length);
    }
    static int getLengthLCS(char[] char1,char[] char2,int m,int n){
     if(m == 0 || n==0){
        return 0;
     }else if(char1[m-1] == char2[n-1]){
        return 1+ getLengthLCS(char1,char2,m-1,n-1);
     }else {
        return Math.max(getLengthLCS(char1,char2,m,n-1),getLengthLCS(char1,char2,m-1,n));
     }
    }
    static void optimalLCS(String s1,String s2,int m,int n){
        char char1[] = s1.toCharArray();
        char char2[] = s2.toCharArray();
        int L[][] = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i ==0 || j==0){
                    L[i][j] = 0;
                }else if(char1[i-1]==char2[j-1] && i!=j){
                    L[i][j] = L[i-1][j-1]+1;
                }else{
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        int index = L[m][n];
        char[] lcs = new char[index+1];
        lcs[index] = '\0';
        int i = m,j=n;
        while(i>0&&j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                lcs[index-1] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            }else if(L[i-i][j]>L[i][j-1]){
                i--;
            }else j--;
        }
        for(char ch:lcs){
            System.out.print(ch);
        }
    }
}
